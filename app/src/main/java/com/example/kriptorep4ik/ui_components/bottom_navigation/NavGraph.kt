package com.example.kriptorep4ik.ui_components.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.parse_data.CurrencyViewModel
import com.example.kriptorep4ik.ui_components.screens.primary.Primary
import com.example.kriptorep4ik.ui_components.screens.Screen2
import com.example.kriptorep4ik.ui_components.screens.Screen3
import com.example.kriptorep4ik.ui_components.screens.Screen4
import com.example.kriptorep4ik.ui_components.screens.primary.primary_screens.AllScreen

@Composable
fun NavGraph(navHostController: NavHostController, viewModel: CurrencyViewModel) {
    NavHost(navController = navHostController, startDestination = "primary") {

        composable("primary") {
            val parserRequest by viewModel.liveData.observeAsState(emptyList())
            Primary(parserRequest)
        }
        composable("exchange") { Screen2() }
        composable("convert") { Screen3() }
        composable("res") { Screen4() }


//        composable("all") {
//            AllScreen {
//                navHostController.navigate("elected")
//            }
//        }
//        composable("elected") {
//
//        }
    }
}