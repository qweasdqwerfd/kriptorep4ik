package com.example.kriptorep4ik.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedValue(
    value: String,
    modifier: Modifier = Modifier,
    highlightColor: Color = Color.Yellow,
    textColor: Color = Color.Black
) {
    var isHighlighted by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(
        targetValue = if (isHighlighted) highlightColor else Color.Transparent,
        animationSpec = tween(durationMillis = 500)
    )

    // Запускаем анимацию подсветки при изменении значения
    LaunchedEffect(value) {
        isHighlighted = true
        delay(1000) // Подсветка длится 1 секунду
        isHighlighted = false
    }

    Box(
        modifier = modifier
            .background(backgroundColor)
            .padding(4.dp)
    ) {
        AnimatedContent(
            targetState = value,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }
        ) { targetValue ->
            Text(
                text = targetValue,
                color = textColor
            )
        }
    }
}