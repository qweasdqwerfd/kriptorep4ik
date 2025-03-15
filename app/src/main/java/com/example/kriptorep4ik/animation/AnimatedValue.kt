package com.example.kriptorep4ik.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun AnimatedValue(
    value: String,
    valueFontSize: Int,
    modifier: Modifier = Modifier,
    highlightColor: Color = Color.Yellow,
    textColor: Color = Color.White
) {
    var previousValue by remember { mutableStateOf(value) }
    var animationTrigger by remember { mutableStateOf(false) }

    val animatedColor by animateColorAsState(
        targetValue = if (animationTrigger) highlightColor else textColor,
        animationSpec = tween(durationMillis = 500)
    )

    LaunchedEffect(value) {
        if (value != previousValue) {
            animationTrigger = true
            delay(500) // Вспышка длится 0.5 сек
            animationTrigger = false
            previousValue = value
        }
    }

    Text(
        text = value,
        modifier = modifier
            .padding(4.dp),
        color = animatedColor,
        fontSize = valueFontSize.sp
    )
}
