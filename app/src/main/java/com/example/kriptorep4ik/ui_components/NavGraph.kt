package com.example.kriptorep4ik.ui_components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.parse_data.models.MarketModel
import com.example.kriptorep4ik.parse_data.models.NewsItem
import com.example.kriptorep4ik.ui_components.screens.CalendarScreen
import com.example.kriptorep4ik.ui_components.screens.account.AccountScreen
import com.example.kriptorep4ik.ui_components.screens.markets.Markets
import com.example.kriptorep4ik.ui_components.screens.news.NewsTab
import com.example.kriptorep4ik.ui_components.screens.news.screens.NewsScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    currenciesList: Map<String, Map<String, List<MarketModel>>>,
    newDataList: List<NewsItem>,
    economyDataList: List<NewsItem>,
    marketsDataList: List<NewsItem>,



    ) {
    NavHost(navController = navHostController, startDestination = "news") {
        composable("calendar") {
            CalendarScreen()
        }
        composable("markets") {
            Markets(
                currenciesList,
            )
        }
        composable("news") {
            NewsScreen(newDataList)
            NewsTab(
                newDataList,
                economyDataList,
                marketsDataList
            )

        }
        composable("account") {
            AccountScreen()
        }

    }
}