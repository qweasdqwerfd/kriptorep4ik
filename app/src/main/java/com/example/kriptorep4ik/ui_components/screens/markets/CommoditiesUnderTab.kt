package com.example.kriptorep4ik.ui_components.screens.markets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kriptorep4ik.parse_data.models.CommoditiesModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CommoditiesUnderTab(
    commoditiesList: Map<String, List<CommoditiesModel>>,
    modifier: Modifier = Modifier
) {
    if (commoditiesList.isEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No data available")
        }
        return
    }

    val categories = commoditiesList.keys.toList()
    val listState = rememberLazyListState()
    var selectedTabIndex by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    // Рассчитываем позиции заголовков
    val headerPositions = remember(categories) {
        val positions = mutableListOf<Int>()
        var currentPosition = 0

        categories.forEachIndexed { index, _ ->
            positions.add(currentPosition)
            currentPosition += commoditiesList[categories[index]]?.size ?: 0 + 1 // +1 для sticky header
        }
        positions
    }

    Column(modifier = modifier) {
        // Вторая панель табов (для подкатегорий)
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.LightGray,
            contentColor = Color.Black,
            edgePadding = 8.dp,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(2.dp),
                    color = Color.Red
                )
            }
        ) {
            categories.forEachIndexed { index, category ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        coroutineScope.launch {
                            listState.animateScrollToItem(headerPositions[index])
                        }
                    },
                    text = {
                        Text(
                            text = category,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }
        }

        // Основной контент
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            commoditiesList.forEach { (category, items) ->
                stickyHeader {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray.copy(alpha = 0.7f))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = category,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }

                items(items) { item ->
                    CommodityItem(item = item)
                }
            }
        }

        // Автоматическое переключение табов при скролле
        LaunchedEffect(listState.firstVisibleItemIndex) {
            val visibleIndex = listState.firstVisibleItemIndex
            val currentSection = headerPositions.lastOrNull { it <= visibleIndex } ?: 0
            if (selectedTabIndex != headerPositions.indexOf(currentSection)) {
                selectedTabIndex = headerPositions.indexOf(currentSection)
            }
        }
    }
}

@Composable
private fun CommodityItem(item: CommoditiesModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name, fontWeight = FontWeight.Bold)
            Text(text = "Price: ${item.price}")
            Text(
                text = "Change: ${item.percent}",
                color = if (item.percent.startsWith("-")) Color.Red else Color.Green
            )
        }
    }
}