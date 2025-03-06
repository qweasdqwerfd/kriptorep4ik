package com.example.kriptorep4ik.ui_components.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.parse_data.ParserModel
import com.example.kriptorep4ik.ui_components.screens.primary.Primary
import com.example.kriptorep4ik.ui_components.screens.Screen2
import com.example.kriptorep4ik.ui_components.screens.Screen3
import com.example.kriptorep4ik.ui_components.screens.Screen4
import com.example.kriptorep4ik.ui_components.screens.primary.primary_screens.AdditionScreen
import com.example.kriptorep4ik.ui_components.screens.primary.primary_screens.AllScreen
import com.example.kriptorep4ik.ui_components.screens.primary.primary_screens.Elected

@Composable
fun NavGraph(navHostController: NavHostController, parserRequest: List<ParserModel>) {

    NavHost(navController = navHostController, startDestination = "primary") {

        composable("primary") {
            Primary(parserRequest)
        }
        composable("exchange") { Screen2() }
        composable("convert") { Screen3() }
        composable("res") { Screen4() }



        composable("addition") {
            AdditionScreen(parserRequest)
        }
        composable("allScreen") {
            AllScreen(parserRequest)
        }

        composable("elected") {
           Elected()
        }
    }
}