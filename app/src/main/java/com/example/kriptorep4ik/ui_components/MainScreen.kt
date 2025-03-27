package com.example.kriptorep4ik.ui_components

import Screen2
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.ViewModel
import com.example.kriptorep4ik.parse_data.markets.AllMarkets
import com.example.kriptorep4ik.ui_components.bottom_navigation.BottomNavigation
import com.example.kriptorep4ik.ui_components.bottom_navigation.NavGraph
import com.example.kriptorep4ik.ui_components.modal_bottom_sheet.CustomModalBottomSheet
import com.example.kriptorep4ik.ui_components.screens.markets.Markets
import com.example.kriptorep4ik.ui_components.screens.markets.MarketsTabs
import com.example.kriptorep4ik.ui_components.screens.primary.Primary
import com.example.kriptorep4ik.ui_components.top_bar.TopBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@Composable
fun MainScreen(viewModel: ViewModel = viewModel()) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = colorResource(R.color.MainInterface)

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = false
        )
    }

    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            viewModel.commoditiesState
            viewModel.currencyState
            viewModel.getAllMarketsState
        }
    }

    val currencyList by viewModel.currencyState.collectAsState()
    val commoditiesList by viewModel.commoditiesState.collectAsState()
    val currenciesList by viewModel.getAllMarketsState.collectAsState()




    Primary(currencyList)
    Markets(
        commoditiesList
    )
    MarketsTabs(
        commoditiesList,
        currenciesList
    )
    AllMarkets(
        currenciesList
    )


    Scaffold(
        topBar = {
            TopBar(
                navController,
                coroutineScope,
                currencyList,
                commoditiesList,
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
                currencyList,
                commoditiesList
            )
            Screen2()
        }
    }

    if (showBottomSheet) {
        CustomModalBottomSheet(
            showBottomSheet = showBottomSheet,
            onDismissRequest = { showBottomSheet = false }
        )
    }
}