package com.example.kriptorep4ik.ui_components.screens.news

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kriptorep4ik.R

@Preview(showBackground = true)
@Composable
fun NewsPanelItem() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
    ) {

        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.cardBack),
                contentColor = Color.White,
            ),
            onClick = {}
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                // Заголовок
                Text(
                    text = "US Stocks Lack Direction",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Строка с тегами
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Тег страны
                    Box(
                        modifier = Modifier
                            .background(
                                color = colorResource(R.color.countryBack),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .clickable {  },
                    ) {
                        Text(
                            text = "United States",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Тег категории
                    Box(
                        modifier = Modifier
                            .background(
                                color = colorResource(R.color.categoryBack),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .clickable {  },
                    ) {
                        Text(
                            text = "Stock Market",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Текст новости
                Text(
                    text = "The S&P Global Brazil Manufacturing PMI slipped to 51.8 " +
                            "in March of 2025 from 53.0 in the previous month, marking " +
                            "the fourteenth monthly expansion in factory activity, but " +
                            "remaining firmly below the average from the previous year. " +
                            "New orders expanded at a slower pace than in February, reflecting " +
                            "the softening demand for the sector as the weaker local currency and" +
                            " high interest rates dampened client demand. Meanwhile, output levels " +
                            "increased for the sixth time in seven months, as the solid production " +
                            "volumes sustained the expansion. At the same time, input cost inflation " +
                            "eased to a three-month low, with selling prices rising at the weakest rate" +
                            " since May 2024. Looking forward, goods producers remained optimistic" +
                            " about future output levels amid expectations of new export " +
                            "opportunities and investment, particularly for those in the " +
                            "agriculture, automotive, and construction sectors.",
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    maxLines = 7,
                    overflow = TextOverflow.Ellipsis,
                    color = colorResource(R.color.textColor)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    horizontalArrangement = Arrangement.End
                ) {

                    Icon(
                        painter = painterResource(R.drawable.link),
                        contentDescription = "link",
                        modifier = Modifier
                            .size(14.dp)
                            .padding(top = 5.dp)
                        ,
                        tint = colorResource(R.color.linkColor)
                        )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        modifier = Modifier
                            .padding(top = 5.dp),

                        text = "19 minutes ago",
                        fontSize = 9.sp,
                        color = colorResource(R.color.textColor),
                    )

                }

            }
        }
    }
}