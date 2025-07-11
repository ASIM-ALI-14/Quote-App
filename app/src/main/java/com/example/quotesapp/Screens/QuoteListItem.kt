package com.example.quotesapp.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotesapp.Models.Quote

import com.example.quotesapp.R


@Composable
fun QuoteListItem(quote: Quote,onClick:(quote:Quote)-> Unit) {
    val MontserratFont = FontFamily(
        Font(R.font.montserrat_regular)
    )
    ElevatedCard(
        modifier = Modifier
            .padding(6.dp, 8.dp, 6.dp, 8.dp)
            .clickable{onClick(quote)}
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

    )
    {
        Box(modifier = Modifier.padding(15.dp)) {
            Row() {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    colorFilter = ColorFilter.tint(Color.White),

                    modifier = Modifier
                        .background(Color.Black)
                        .padding(2.dp)
                        .size(33.dp)
                        .rotate(180F)


                )
                Spacer(modifier = Modifier.width(13.dp))
                Column() {
                    Text(
                        text = "${quote.text}",
                        fontFamily = MontserratFont,

                        style = MaterialTheme.typography.bodyLarge,


                        modifier = Modifier.padding(0.dp, 0.dp, 23.dp, 8.dp)
                    )
                    Box(
                        modifier =
                            Modifier
                                .fillMaxWidth(.4f)
                                .height(1.dp)
                                .background(Color(0xFFE0E0E0))
                    )
                    Text(
                        text = "${quote.author}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Thin, modifier = Modifier.padding(top = 9.dp)
                    )
                }
            }
        }
    }


}