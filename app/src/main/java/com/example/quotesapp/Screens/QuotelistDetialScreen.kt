package com.example.quotesapp.Screens


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import com.example.quotesapp.R

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.quotesapp.DataManager
import com.example.quotesapp.Models.Quote


@Composable
fun QuoteListDetial(quote: Quote) {
    BackHandler() {
        DataManager.switchpages(null)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surface,
                        MaterialTheme.colorScheme.surfaceVariant
                    )
                )
            ), contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier.padding(22.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp, 24.dp)
            ) {
                Image(imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),

                    modifier = Modifier.size(62.dp).rotate(180F))

                Text(text = "${quote.text}",
                    modifier = Modifier.padding(2.dp,2.dp,23.dp,19.dp),
                    style = MaterialTheme.typography.titleLarge
                    , fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)))
                Text(text = "${quote.author}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Normal
                )

            }
        }
    }
}