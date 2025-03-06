package com.example.kriptorep4ik.ui_components.screens.primary.primary_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.ParserModel

@Composable
fun AdditionScreen(parserRequest: List<ParserModel>) {
    var selectTabIndex by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectTabIndex,
            modifier = Modifier.fillMaxWidth(),
            containerColor = colorResource(R.color.MainInterface),
            contentColor = White
        ) {
            Tab(
                selected = selectTabIndex == 0,
                onClick = {
                    selectTabIndex = 0;
                },
                text = {
                    Text(
                        "Избранное",
                        color = White,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                },
            )
            Tab(
                selected = selectTabIndex == 1,
                onClick = {
                    selectTabIndex = 1
                },
                text = {
                    Text(
                        "Все",
                        color = White,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                },
            )
        }
        when (selectTabIndex) {
            0 -> Elected()
            1 -> AllScreen(parserRequest)
        }
    }
}