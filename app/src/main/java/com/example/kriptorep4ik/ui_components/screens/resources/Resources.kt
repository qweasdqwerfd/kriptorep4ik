package com.example.kriptorep4ik.ui_components.screens.resources

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Resources() {
    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        textAlign = TextAlign.Center,
        text = "Screen 4"
    )
}