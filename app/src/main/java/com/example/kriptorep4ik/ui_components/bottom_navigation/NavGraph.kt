package com.example.kriptorep4ik.ui_components.bottom_navigation

import Screen2
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel
import com.example.kriptorep4ik.parse_data.commodities.MarketsModel
import com.example.kriptorep4ik.ui_components.screens.Screen3
import com.example.kriptorep4ik.ui_components.screens.primary.Primary
import com.example.kriptorep4ik.ui_components.screens.primary.primary_screens.AdditionScreen
import com.example.kriptorep4ik.ui_components.screens.markets.Markets

@Composable
fun NavGraph(
    navHostController: NavHostController,
    parserRequest: List<CurrencyModel>,
    resourceState: List<MarketsModel>,

    ) {
    NavHost(navController = navHostController, startDestination = "res") {
        composable("primary") {
            Primary(parserRequest)
        }
        composable("exchange") {
            Screen2()
        }
        composable("convert") {
            Screen3()
        }
        composable("res") {
            Markets(resourceState)
        }
        composable("addition") {
            AdditionScreen(parserRequest)
        }
    }
}