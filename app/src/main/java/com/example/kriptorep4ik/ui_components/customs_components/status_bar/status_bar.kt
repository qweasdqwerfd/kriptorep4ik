package com.example.kriptorep4ik.ui_components.customs_components.status_bar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.res.colorResource
import com.example.kriptorep4ik.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun StatusBar() {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = colorResource(R.color.MainInterface)

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = false
        )
    }
}