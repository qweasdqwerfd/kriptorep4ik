package com.example.kriptorep4ik.ui_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.kriptorep4ik.parse_data.ViewModel
import com.example.kriptorep4ik.ui_components.bottom_navigation.BottomNavigation
import com.example.kriptorep4ik.ui_components.bottom_navigation.NavGraph
import com.example.kriptorep4ik.ui_components.modal_bottom_sheet.CustomModalBottomSheet
import com.example.kriptorep4ik.ui_components.screens.primary.Primary
import com.example.kriptorep4ik.ui_components.top_bar.TopBar


@Composable
fun MainScreen(viewModel: ViewModel = viewModel()) {


    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
//    val snackBarHostState = remember { SnackbarHostState() }
    var showBottomSheet by remember { mutableStateOf(false) }


    val testViewModel = viewModel
    val currencyState by viewModel.currencyState.collectAsState()
    val resourceState by viewModel.parserResourcesEnergy.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadData()
        viewModel.fetchData()
    }


    Primary(currencyState)






    Scaffold(
        topBar = {
            TopBar(
                navController,
                coroutineScope,
                currencyState
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
            NavGraph(navController, currencyState)
        }
    }

    if (showBottomSheet) {
        CustomModalBottomSheet(
            showBottomSheet = showBottomSheet,
            onDismissRequest = { showBottomSheet = false }
        )
    }
}


