package com.example.kriptorep4ik.visual.instruments.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.visual.instruments.screens.Screen1
import com.example.kriptorep4ik.visual.instruments.screens.Screen2
import com.example.kriptorep4ik.visual.instruments.screens.Screen3
import com.example.kriptorep4ik.visual.instruments.screens.Screen4

@Composable
fun NavGraph(navHostController: NavHostController)                                                  //change screens
{
    NavHost(navController = navHostController, startDestination = "primary")
    {
        composable("primary") { Screen1() }
        composable("exchange") { Screen2() }
        composable("convert") { Screen3() }
        composable("res") { Screen4() }
    }
}