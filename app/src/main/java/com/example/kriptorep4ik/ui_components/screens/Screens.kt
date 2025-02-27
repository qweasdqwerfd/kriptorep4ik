package com.example.kriptorep4ik.ui_components.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign



@Composable
fun Screen2() {
    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        textAlign = TextAlign.Center,
        text = "Screen 2"
    )
}

@Composable
fun Screen3() {
    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        textAlign = TextAlign.Center,
        text = "Screen 3"
    )
}

@Composable
fun Screen4() {
    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        textAlign = TextAlign.Center,
        text = "Screen 4"
    )
}

@Composable
fun Screen5() {}
