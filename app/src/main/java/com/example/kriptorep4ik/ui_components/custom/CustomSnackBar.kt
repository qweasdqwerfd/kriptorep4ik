package com.example.kriptorep4ik.visual.instruments.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



@Composable
fun CustomSnackBar(data: SnackbarData) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .background(Color.Gray, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = data.visuals.message,
                color = Color.White,
                modifier = Modifier.padding(end = 8.dp, start = 8.dp)
            )
            if (data.visuals.actionLabel != null) {
                TextButton(
                    onClick = { data.performAction() }, // Выполнить действие
                    colors = ButtonDefaults.textButtonColors(contentColor = Color.Yellow)
                ) {
                    Text(text = data.visuals.actionLabel!!)
                }
            }
        }
    }
}