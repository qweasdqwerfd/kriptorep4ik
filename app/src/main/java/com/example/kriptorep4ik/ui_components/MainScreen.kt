package com.example.kriptorep4ik.ui_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.kriptorep4ik.parse_data.ViewModel
import com.example.kriptorep4ik.ui_components.bottom_navigation.BottomNavigation
import com.example.kriptorep4ik.ui_components.customs_components.status_bar.StatusBar
import com.example.kriptorep4ik.ui_components.screens.markets.Markets
import com.example.kriptorep4ik.ui_components.screens.markets.MarketsTabs
import com.example.kriptorep4ik.ui_components.screens.news.screens.EconomyScreen
import com.example.kriptorep4ik.ui_components.screens.news.screens.MarketsScreen
import com.example.kriptorep4ik.ui_components.screens.news.screens.NewsScreen
import com.example.kriptorep4ik.ui_components.top_bar.TopBar
import kotlinx.coroutines.launch

@Composable
fun MainScreen(viewModel: ViewModel = viewModel()) {
    StatusBar()
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            viewModel.getAllMarketsState
            viewModel.loadNewData()
            viewModel.loadEconomyData()
            viewModel.loadMarketsData()
        }
    }


    val currenciesList by viewModel.getAllMarketsState.collectAsState()
    val newDataList by viewModel.getNewsData.collectAsState()
    val economyDataList by viewModel.getEconomyData.collectAsState()
    val marketsDataList by viewModel.getMarketsData.collectAsState()




    Markets(
        currenciesList,
    )
    MarketsTabs(
        currenciesList
    )
    NewsScreen(
        newDataList,

    )
    EconomyScreen(
        economyDataList
    )
    MarketsScreen(
        marketsDataList
    )



    Scaffold(
        topBar = {
            TopBar(
                navController,
                coroutineScope,
                currenciesList
            )
        },
        bottomBar = {
            BottomNavigation(
                navController = navController,
                onBottomNavClick = { showBottomSheet = true }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavGraph(
                navController,
                currenciesList,
                newDataList,
                economyDataList,
                marketsDataList
            )

        }
    }
}