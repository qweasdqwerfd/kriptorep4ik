package com.example.kriptorep4ik.parse_data.markets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.models.AllMarketsModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AllMarkets(
    resourceCommodities: Map<String, Map<String, List<AllMarketsModel>>>
) {
    if (resourceCommodities.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = "Загрузка данных",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    } else {
        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxSize()
        ) {
            LazyColumn {
                resourceCommodities.forEach { (category, subCategories) ->
                    // Заголовок основной категории
                    stickyHeader {
                        Text(
                            text = category,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.DarkGray)
                                .padding(16.dp),
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    subCategories.forEach { (subCategory, items) ->
                        // Подзаголовок подкатегории
                        item {
                            Text(
                                text = subCategory,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Gray.copy(alpha = 0.5f))
                                    .padding(vertical = 8.dp, horizontal = 16.dp),
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        // Элементы подкатегории
                        items(items) { item ->
                            PanelItemAllMarkets(model = item)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun PanelItemAllMarkets(
    model: AllMarketsModel,
) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.MainInterface),
            contentColor = colorResource(id = R.color.MainInterface)
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.MainInterface),
                contentColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = model.name,
                            fontSize = 15.sp,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start
                        )

                    }

                    Column(
                        modifier = Modifier
                            .width(90.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = model.price,
                            fontSize = 13.sp,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )

                        Text(
                            text = model.date,
                            fontSize = 10.sp,
                            color = Color.Gray,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp),
                            textAlign = TextAlign.End
                        )
                    }

                    Column(
                        modifier = Modifier.width(50.dp)
                    ) {
                        Text(
                            text = model.percent,
                            fontSize = 13.sp,
                            color = getColorForValue(model.percent),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )

                        Text(
                            text = model.dayChange,
                            fontSize = 12.sp,
                            color = getColorForValue(model.percent),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun getColorForValue(value: String): Color {
    val numericValue = value.replace("%", "").toDoubleOrNull() ?: 0.0
    return if (numericValue >= 0) {
        colorResource(R.color.MyGreen)
    } else {
        colorResource(R.color.MyRed)
    }
}
