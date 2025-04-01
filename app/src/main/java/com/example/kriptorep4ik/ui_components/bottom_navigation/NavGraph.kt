package com.example.kriptorep4ik.ui_components.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.parse_data.models.MarketModel
import com.example.kriptorep4ik.ui_components.screens.AccountScreen
import com.example.kriptorep4ik.ui_components.screens.CalendarScreen
import com.example.kriptorep4ik.ui_components.screens.NewScreen
import com.example.kriptorep4ik.ui_components.screens.markets.Markets

@Composable
fun NavGraph(
    navHostController: NavHostController,
    currenciesList: Map<String, Map<String, List<MarketModel>>>,



    ) {
    NavHost(navController = navHostController, startDestination = "markets") {
        composable("calendar") {
            CalendarScreen()
        }
        composable("markets") {
            Markets(
                currenciesList,
            )
        }
        composable("news") {
            NewScreen()
        }
        composable("account") {
            AccountScreen()
        }

    }
}