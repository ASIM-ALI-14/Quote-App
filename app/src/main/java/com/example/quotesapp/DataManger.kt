package com.example.quotesapp

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.Models.Quote
import com.example.quotesapp.Models.screen
import com.google.gson.Gson

object DataManager {
    var currentpage = mutableStateOf(screen.ListScreen)
    var currentQuote: Quote? = null
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)
    fun loadAssetsFromFile(context: Context) {
        try {
            val inputStream = context.assets.open("quotes.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, Charsets.UTF_8)

            data = Gson().fromJson(json, Array<Quote>::class.java)
            isDataLoaded.value = true
        } catch (e: Exception) {
            Log.e("DataManager", "Error loading file: ${e.message}")
            isDataLoaded.value = false
        }
        }
    fun switchpages(quote: Quote?){
        if(currentpage.value== screen.ListScreen){
            currentQuote=quote
            currentpage.value=screen.DetialScreen
        }else{
            currentpage.value=screen.ListScreen
        }
    }
}
