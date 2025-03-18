package com.example.kriptorep4ik.ui_components

import Screen2
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
import com.example.kriptorep4ik.ui_components.bottom_navigation.NavGraph
import com.example.kriptorep4ik.ui_components.modal_bottom_sheet.CustomModalBottomSheet
import com.example.kriptorep4ik.ui_components.screens.markets.Markets
import com.example.kriptorep4ik.ui_components.screens.primary.Primary
import com.example.kriptorep4ik.ui_components.top_bar.TopBar
import kotlinx.coroutines.launch

@Composable
fun MainScreen(viewModel: ViewModel = viewModel()) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    val currencyStateCurrency by viewModel.currencyState.collectAsState()
    val resourceStateEnergy by viewModel.parserCommoditiesEnergy.collectAsState()
    val resourceStateMetals by viewModel.parserCommoditiesMetals.collectAsState()
    val resourceStateAgricultural by viewModel.parserCommoditiesAgricultural.collectAsState()
    val resourceStateIndustrial by viewModel.parserCommoditiesIndustrial.collectAsState()
    val resourceStateLiveStock by viewModel.parserLiveStock.collectAsState()
    val resourceStateIndex by viewModel.parserIndex.collectAsState()
    val resourceStateElectricity by viewModel.parserElectricity.collectAsState()



    LaunchedEffect(Unit) {
        coroutineScope.launch {
            viewModel.loadCurrencyData()
            viewModel.loadEnergyData()
            viewModel.loadMetalsData()
            viewModel.loadAgriculturalData()
            viewModel.loadIndustrialData()
            viewModel.loadLiveStockData()
            viewModel.loadIndexData()
            viewModel.loadElectricityData()

        }


    }

    Primary(currencyStateCurrency)
    Markets(
        resourceStateEnergy,
        resourceStateMetals,
        resourceStateAgricultural,
        resourceStateIndustrial,
        resourceStateLiveStock,
        resourceStateIndex,
        resourceStateElectricity
    )



    Scaffold(
        topBar = {
            TopBar(
                navController,
                coroutineScope,
                currencyStateCurrency
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
                resourceStateEnergy,
                resourceStateMetals,
                resourceStateAgricultural,
                resourceStateIndustrial,
                resourceStateLiveStock,
                resourceStateIndex,
                resourceStateElectricity
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