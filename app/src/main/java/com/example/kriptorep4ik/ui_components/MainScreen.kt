package com.example.kriptorep4ik.visual.instruments

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.kriptorep4ik.visual.instruments.bottom_navigation.BottomNavigation
import com.example.kriptorep4ik.visual.instruments.custom.CustomSnackBar
import com.example.kriptorep4ik.visual.instruments.bottom_navigation.NavGraph
import com.example.kriptorep4ik.visual.instruments.top_bar.TopBar



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(

        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState) { data ->
                CustomSnackBar(data)
            }
        },

        topBar = { TopBar(navController, coroutineScope, snackBarHostState) },

        bottomBar = { BottomNavigation(navController = navController) }

    ) {
        NavGraph(navController)

    }
}



