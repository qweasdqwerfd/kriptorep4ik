package com.example.kriptorep4ik.ui_components.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.logic.CurrencyViewModel
import com.example.kriptorep4ik.ui_components.screens.primary.primary
import com.example.kriptorep4ik.ui_components.screens.Screen2
import com.example.kriptorep4ik.ui_components.screens.Screen3
import com.example.kriptorep4ik.ui_components.screens.Screen4

@Composable
fun NavGraph(navHostController: NavHostController, viewModel: CurrencyViewModel) {
    NavHost(navController = navHostController, startDestination = "primary") {

        composable("primary") {
            val rates by viewModel.currencyRates.observeAsState(emptyList())
            primary(rates = rates)
        }
        composable("exchange") { Screen2() }
        composable("convert") { Screen3() }
        composable("res") { Screen4() }
    }
}