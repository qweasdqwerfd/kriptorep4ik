package com.example.kriptorep4ik.ui_components.customs_components.launch_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.ui_components.instruments.launchScreenColor

@Preview(showBackground = true)
@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(launchScreenColor),
        contentAlignment = Alignment.Center
    ) {
        // Надежная загрузка изображения
        val image = remember { R.drawable.launch_logo }

        Image(
            painter = painterResource(id = image),
            contentDescription = "Логотип",
            modifier = Modifier.size(200.dp)
        )
    }
}
