package com.example.kriptorep4ik.ui_components.screens.resources

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.kriptorep4ik.parse_data.resources.ResourcesModel

@Composable
fun Resources(resourceState: List<ResourcesModel>) {
    Column(
        modifier = Modifier
            .background(color = Color.Black)
    ) {
        LazyColumn {
            items(resourceState) { item ->
                PanelItemResources(model = item)
            }
        }

    }
}

@Composable
fun PanelItemResources(
    model: ResourcesModel
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
                // Первая строка: Название, цена, процент
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

                    // Цена
                    AnimatedValue(
                        value = model.price,
                        modifier = Modifier.width(80.dp),
                        highlightColor = Color.Yellow.copy(alpha = 0.5f),
                        textColor = Color.Black
                    )

                    // Процент
                    AnimatedValue(
                        value = model.percent,
                        modifier = Modifier.width(50.dp),
                        highlightColor = if ((model.percent.replace("%", "")
                                .toDoubleOrNull() ?: 0.0) > 0) Color.Green else Color.Red,
                        textColor = if ((model.percent.replace("%", "")
                                .toDoubleOrNull() ?: 0.0) > 0) Color.Green else Color.Red
                    )
                }

                // Вторая строка: Дополнительное название, дата, изменение за день
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Дополнительное название
                    Text(
                        text = model.additionalName,
                        fontSize = 10.5.sp,
                        modifier = Modifier.weight(1f),
                        color = Color.White,
                        style = TextStyle(fontWeight = FontWeight.Normal),
                        textAlign = TextAlign.Start
                    )

                    // Дата
                    Text(
                        text = model.date,
                        fontSize = 10.sp,
                        modifier = Modifier.width(80.dp),
                        color = Color.Gray,
                        textAlign = TextAlign.End
                    )

                    // Изменение за день
                    AnimatedValue(
                        value = model.dayChange,
                        modifier = Modifier.width(50.dp),
                        highlightColor = if ((model.dayChange.toDoubleOrNull() ?: 0.0) > 0) Color.Green else Color.Red,
                        textColor = if ((model.dayChange.toDoubleOrNull() ?: 0.0) > 0) Color.Green else Color.Red
                    )
                }
            }
        }
    }
}