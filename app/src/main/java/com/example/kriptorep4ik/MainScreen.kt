package com.example.kriptorep4ik

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.kriptorep4ik.visual.bottom_navigation.BottomNavigation
import com.example.kriptorep4ik.visual.bottom_navigation.NavGraph
import com.example.kriptorep4ik.visual.bottom_navigation.TopBar.CustomTopBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    Scaffold(

        topBar = { CustomTopBar(navController, coroutineScope, snackbarHostState) },

        bottomBar = { BottomNavigation(navController = navController) }

    ) {
        NavGraph(navController)

    }
}



