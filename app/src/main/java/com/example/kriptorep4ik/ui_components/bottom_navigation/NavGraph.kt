package com.example.kriptorep4ik.ui_components.bottom_navigation

import Screen2
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel
import com.example.kriptorep4ik.parse_data.models.MarketModel
import com.example.kriptorep4ik.ui_components.screens.Screen3
import com.example.kriptorep4ik.ui_components.screens.markets.Markets
import com.example.kriptorep4ik.ui_components.screens.primary.Primary
import com.example.kriptorep4ik.ui_components.screens.primary.primary_screens.change.AdditionScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    parserRequest: List<CurrencyModel>,
    currenciesList: Map<String, Map<String, List<MarketModel>>>,



    ) {
    NavHost(navController = navHostController, startDestination = "markets") {
        composable("calendar") {
            Primary(parserRequest)
        }
        composable("exchange") {
            Screen2()
        }
        composable("convert") {
            Screen3()
        }
        composable("markets") {
            Markets(
                currenciesList,
            )
        }
        composable("addition") {
            AdditionScreen(parserRequest)
        }
    }
}