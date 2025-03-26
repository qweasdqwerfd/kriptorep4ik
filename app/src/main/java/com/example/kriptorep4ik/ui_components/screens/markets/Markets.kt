package com.example.kriptorep4ik.ui_components.screens.markets

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
import com.example.kriptorep4ik.parse_data.commodities.MarketsModel

@Composable
fun Markets(
    resourceCommodities: Map<String, List<MarketsModel>>
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
            modifier = Modifier.background(color = Color.Black)
        ) {
            LazyColumn {
                resourceCommodities.forEach { (category, items) ->
                    item {
                        Text(
                            text = category,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    items(items) { item ->
                        PanelItemCommodities(model = item)
                    }
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

                        Text(
                            modifier = Modifier
                                .padding(top = 4.dp),
                            text = model.additionalName,
                            fontSize = 11.sp,
                            color = Color.White,
                            style = TextStyle(fontWeight = FontWeight.Normal),
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
