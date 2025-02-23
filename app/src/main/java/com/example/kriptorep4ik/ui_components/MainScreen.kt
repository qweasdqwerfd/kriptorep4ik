package com.example.kriptorep4ik.ui_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kriptorep4ik.ui_components.bottom_navigation.BottomNavigation
import com.example.kriptorep4ik.ui_components.bottom_navigation.NavGraph
import com.example.kriptorep4ik.ui_components.snack_bar.CustomSnackBar
import com.example.kriptorep4ik.ui_components.modal_bottom_sheet.CustomModalBottomSheet
import com.example.kriptorep4ik.ui_components.top_bar.TopBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState) { data ->
                CustomSnackBar(data)
            }
        },
        topBar = {
            TopBar(
                navController,
                coroutineScope,
                snackBarHostState = snackBarHostState,
            )
        },
        bottomBar = {
            BottomNavigation(
                navController = navController,
                onBottomNavClick = { showBottomSheet = true }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavGraph(navController)
        }
    }

    if (showBottomSheet) {
        CustomModalBottomSheet(
            showBottomSheet = showBottomSheet,
            onDismissRequest = { showBottomSheet = false }
        )
    }
}


