package com.example.kriptorep4ik.ui_components.screens.markets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.Bonds
import com.example.kriptorep4ik.parse_data.Crypto
import com.example.kriptorep4ik.parse_data.Currencies
import com.example.kriptorep4ik.parse_data.Indexes
import com.example.kriptorep4ik.parse_data.Watchlist
import com.example.kriptorep4ik.parse_data.commodities.MarketsModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MarketsTabs(commoditiesStateCurrency: Map<String, List<MarketsModel>>) {

    val tabs = listOf("Commodities", "Currencies", "Indexes", "Bonds", "Crypto", "Watchlist")
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = colorResource(R.color.MainInterface),
            contentColor = Color.White,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .height(4.dp)
                        .background(color = Color.White)
                )
            }
            ) {
            tabs.forEachIndexed {index, title ->
                androidx.compose.material3.Tab(
                    modifier = Modifier.wrapContentWidth(),
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(

                            text = title,
                            color = Color.White,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .wrapContentWidth(),
                        )
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
                0 -> Markets(commoditiesStateCurrency)
                1 -> Currencies()
                2 -> Indexes()
                3 -> Bonds()
                4 -> Crypto()
                5 -> Watchlist()
            }
        }
    }

}