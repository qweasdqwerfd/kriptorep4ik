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
            darkIcons = false // или true, если иконки должны быть тёмными
        )
    }

    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }



    LaunchedEffect(Unit) {
        coroutineScope.launch {
            viewModel.parserData
            viewModel.currencyState
        }
    }

    val currencyStateCurrency by viewModel.currencyState.collectAsState()
    val commoditiesStateCurrency by viewModel.parserData.collectAsState()


    Primary(currencyStateCurrency)
    Markets(
        commoditiesStateCurrency
    )
    MarketsTabs(
        commoditiesStateCurrency
    )



    Scaffold(
        topBar = {
            TopBar(
                navController,
                coroutineScope,
                currencyStateCurrency,
                commoditiesStateCurrency
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
                currencyStateCurrency,
                commoditiesStateCurrency
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