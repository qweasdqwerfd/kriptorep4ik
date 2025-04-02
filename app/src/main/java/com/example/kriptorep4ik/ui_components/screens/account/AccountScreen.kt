package com.example.kriptorep4ik.ui_components.screens.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kriptorep4ik.R

@Composable
fun AccountScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .offset(y = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign in to\n" +
                "Create Economic and Market Alerts\n" +
                "Add Economic Events and Market Indicators to your Watchlist\n" +
                "Sync your Alerts and Watchlist across devices",
            modifier = Modifier.padding(bottom = 32.dp),
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            )

        TextButton(
            onClick = {},
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.White,
                containerColor = colorResource(id = R.color.SignInButton),
            ),
            shape = RoundedCornerShape(10.dp),
            ) {
            Text(
                text = "Sign In",
                color = Color.White,
            )
        }

    }
}