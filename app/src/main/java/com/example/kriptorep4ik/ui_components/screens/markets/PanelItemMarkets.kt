package com.example.kriptorep4ik.ui_components.screens.markets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.kriptorep4ik.parse_data.models.MarketModel

@Composable
fun PanelItemMarkets(
    model: MarketModel,
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
                            .width(100.dp)
                            .padding(end = 30.dp)
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
                        modifier = Modifier.width(60.dp)
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