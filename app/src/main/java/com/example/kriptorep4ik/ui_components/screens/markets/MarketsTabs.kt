package com.example.kriptorep4ik.ui_components.screens.markets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.markets.AllMarkets
import com.example.kriptorep4ik.parse_data.models.AllMarketsModel
import com.example.kriptorep4ik.parse_data.models.CommoditiesModel
import com.example.kriptorep4ik.ui_components.screens.Bonds
import com.example.kriptorep4ik.ui_components.screens.Crypto
import com.example.kriptorep4ik.ui_components.screens.Indexes
import com.example.kriptorep4ik.ui_components.screens.Watchlist
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MarketsTabs(
    commoditiesList: Map<String, List<CommoditiesModel>>,
    currenciesList: Map<String, Map<String, List<AllMarketsModel>>>
) {

    val tabs = listOf("Commodities", "Currencies", "Indexes", "Bonds", "Crypto", "Watchlist")
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        ScrollableTabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = colorResource(R.color.MainInterface),
            contentColor = Color.White,
            edgePadding = 0.dp, // <-- убирает отступы по краям
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .height(4.dp)
                        .background(color = Color.White)
                )
            }
            ) {
            tabs.forEachIndexed { index, title ->
                androidx.compose.material3.Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = title,
                                color = Color.White,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                )
            }
        }
        HorizontalPager(
            count = tabs.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> Markets(commoditiesList)
                1 -> AllMarkets(currenciesList)
                2 -> Indexes()
                3 -> Bonds()
                4 -> Crypto()
                5 -> Watchlist()
            }
        }
    }

}