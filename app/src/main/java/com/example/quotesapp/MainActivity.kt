package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quotesapp.Models.screen
import com.example.quotesapp.Screens.QuoteListDetial
import com.example.quotesapp.Screens.QuoteListScreen
import com.example.quotesapp.ui.theme.QuotesAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        DataManager.loadAssetsFromFile(this)
        setContent {

App()

        }
    }
}
@Composable
fun App() {

    var timerDone by remember { mutableStateOf(false) }
    val isDataLoaded = DataManager.isDataLoaded.value


    LaunchedEffect(Unit) {
        delay(3000)
        timerDone = true
    }

    if (!timerDone || !isDataLoaded) {

        Box(
            modifier = Modifier.fillMaxSize(), // fills full screen
            contentAlignment = Alignment.Center // centers child (the loader)
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(44.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }} else {

        if(DataManager.currentpage.value== screen.ListScreen){
            QuoteListScreen(data = DataManager.data){
                DataManager.switchpages(it)
            }
        }
        else{
            QuoteListDetial(quote = DataManager.currentQuote!! )
        }
    }
}



