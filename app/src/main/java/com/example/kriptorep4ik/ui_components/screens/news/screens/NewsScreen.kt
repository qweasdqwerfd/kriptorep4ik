package com.example.kriptorep4ik.ui_components.screens.news.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.kriptorep4ik.parse_data.models.NewsItem
import com.example.kriptorep4ik.ui_components.screens.news.NewsPanelItem
import com.example.kriptorep4ik.ui_components.snack_bar.LoadingScreenWithSkeletons

@Composable
fun NewsScreen(newDataList: List<NewsItem>) {
    if (newDataList.isEmpty()) {
        LoadingScreenWithSkeletons()
    } else {
        LazyColumn {
            items(newDataList) { item ->
                NewsPanelItem(item)
            }
        }
    }
}
