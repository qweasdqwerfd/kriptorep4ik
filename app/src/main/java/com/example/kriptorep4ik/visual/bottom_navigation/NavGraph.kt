package com.example.kriptorep4ik.visual.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kriptorep4ik.visual.bottom_navigation.screen.Screen1
import com.example.kriptorep4ik.visual.bottom_navigation.screen.Screen2
import com.example.kriptorep4ik.visual.bottom_navigation.screen.Screen3
import com.example.kriptorep4ik.visual.bottom_navigation.screen.Screen4
import com.example.kriptorep4ik.visual.bottom_navigation.screen.Screen5

@Composable
fun NavGraph(navHostController: NavHostController)                                                  //change screens
{
    NavHost(navController = navHostController, startDestination = "primary")
    {
        composable("primary") { Screen1() }
        composable("exchange") { Screen2() }
        composable("convert") { Screen3() }
        composable("res") { Screen4() }
        composable("another") { Screen5() }
    }
}