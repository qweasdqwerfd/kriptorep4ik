package com.example.kriptorep4ik.ui_components.screens.primary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.currency.CurrencyImages
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel


@Composable
fun Primary(viewModelList: List<CurrencyModel>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 10.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Курсы валют",
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = Color.White,
                fontSize = 30.sp
            )
        }

        if (viewModelList.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(start = 13.dp, top = 5.dp),
                text = "${viewModelList[0].date}",
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        } else {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Нет данных",
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        }

        LazyColumn {
            items(viewModelList) { rate ->
                CurrencyItem(rate = rate)
            }
        }
    }
}

@Composable
fun CurrencyItem(rate: CurrencyModel) {

    val imageRes = CurrencyImages.images[rate.letterCode] ?: R.drawable.xdr

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray,
            contentColor = Color.White
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = imageRes,
                contentDescription = "currency_image",
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Inside
            )

            Spacer(modifier = Modifier.width(10.dp))

            // Название валюты и код
            Column {

                Text(
                    text = rate.letterCode,
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                )

                Text(
                    text = rate.currency,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.weight(25f))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {

                Text(
                    text = "${rate.change}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = if (rate.change?.toDoubleOrNull() ?: 0.0 > 0) Color.Green else Color.Red
                )

                Spacer(modifier = Modifier.weight(15f))


                Text(
                    text = "${rate.rate} ₽",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.weight(25f))


                Text(
                    text = "${rate.percentageChange}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = if (rate.percentageChange?.replace("%", "")
                            ?.toDoubleOrNull() ?: 0.0 > 0
                    ) Color.Green else Color.Red
                )

            }

        }
//        Row(modifier = Modifier.padding(start = 10.dp), verticalAlignment = Alignment.Bottom) {
//            Text(
//                text = "ед: ${rate.unit}",
//                color = Color.Black,
////                textDecoration = TextDecoration.None
//            )
//        }
    }
}