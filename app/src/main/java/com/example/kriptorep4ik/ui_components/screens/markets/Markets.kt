package com.example.kriptorep4ik.ui_components.screens.markets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.example.kriptorep4ik.animation.AnimatedValue
import com.example.kriptorep4ik.parse_data.commodities.MarketsModel

@Composable
fun Markets(resourceState: List<MarketsModel>) {
    if (resourceState.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            Text(
                text = "Данные загружаются...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

    } else {
        Column(
            modifier = Modifier.background(color = Color.Black)
        ) {
            LazyColumn {
                items(resourceState) { item ->
                    PanelItemCommodities(model = item)
                }
            }
        }
    }
}


@Composable
fun PanelItemCommodities(
    model: MarketsModel,
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
                // Первая строка: Название, Цена, Процент
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Название
                    Text(
                        text = model.name,
                        fontSize = 15.sp,
                        modifier = Modifier.weight(1f),
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Start
                    )

                    // Цена и дата
                    Column(
                        modifier = Modifier
                            .width(80.dp)
                            .fillMaxHeight(),
                        horizontalAlignment = androidx.compose.ui.Alignment.End
                    ) {
                        // Цена
                        AnimatedValue(
                            value = model.price,
                            valueFontSize = 13,
                            modifier = Modifier.fillMaxWidth(),
                            highlightColor = Color.Yellow.copy(alpha = 0.5f),
                            textColor = Color.White
                        )

                        // Дата (ровно под ценой)
                        Text(
                            text = model.date,
                            fontSize = 10.sp,
                            color = Color.Gray,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    }

                    // Процент и изменение за день
                    Column(
                        modifier = Modifier
                            .width(50.dp)
                            .fillMaxHeight(),
                        horizontalAlignment = androidx.compose.ui.Alignment.End
                    ) {
                        // Процент
                        AnimatedValue(
                            value = model.percent,
                            valueFontSize = 13,
                            modifier = Modifier.fillMaxWidth(),
                            highlightColor = if ((model.percent.replace("%", "")
                                    .toDoubleOrNull() ?: 0.0) > 0
                            ) colorResource(R.color.MyGreen) else colorResource(R.color.MyRed),
                            textColor = if ((model.percent.replace("%", "")
                                    .toDoubleOrNull() ?: 0.0) > 0
                            ) colorResource(R.color.MyGreen) else colorResource(R.color.MyRed)
                        )

                        // Изменение за день (ровно под процентом)
                        AnimatedValue(
                            value = model.dayChange,
                            valueFontSize = 12,
                            modifier = Modifier.fillMaxWidth(),
                            highlightColor = if ((model.dayChange.toDoubleOrNull()
                                    ?: 0.0) > 0
                            ) colorResource(R.color.MyGreen) else colorResource(R.color.MyRed),
                            textColor = if ((model.dayChange.toDoubleOrNull()
                                    ?: 0.0) > 0
                            ) colorResource(R.color.MyGreen) else colorResource(R.color.MyRed)
                        )
                    }
                }

                // Вторая строка: Дополнительное название
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = model.additionalName,
                        fontSize = 10.5.sp,
                        modifier = Modifier.weight(1f),
                        color = Color.White,
                        style = TextStyle(fontWeight = FontWeight.Normal),
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
