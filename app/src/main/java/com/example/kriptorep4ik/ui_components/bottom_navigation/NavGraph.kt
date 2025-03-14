package com.example.kriptorep4ik.ui_components.bottom_navigation

import Screen2
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel
import com.example.kriptorep4ik.parse_data.resources.ResourcesModel
import com.example.kriptorep4ik.ui_components.screens.Screen3
import com.example.kriptorep4ik.ui_components.screens.primary.Primary
import com.example.kriptorep4ik.ui_components.screens.primary.primary_screens.AdditionScreen
import com.example.kriptorep4ik.ui_components.screens.resources.Resources

@Composable
fun NavGraph(
    navHostController: NavHostController,
    parserRequest: List<CurrencyModel>,
    resourceState: List<ResourcesModel>,
    context: Context,

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
            Resources(resourceState)
        }
        composable("addition") {
            AdditionScreen(parserRequest)
        }
    }
}