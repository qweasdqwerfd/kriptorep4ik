package com.example.kriptorep4ik.ui_components.screens.news.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.kriptorep4ik.parse_data.models.NewsItem
import com.example.kriptorep4ik.ui_components.screens.news.NewsPanelItem

@Composable
fun EconomyScreen(economyDataList: List<NewsItem>) {

    if (economyDataList.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Загрузка данных", color = Color.White, fontSize = 20.sp)
        }
    } else {
        LazyColumn {

            items(economyDataList) {item ->
                NewsPanelItem(item)
            }
        }
    }
}