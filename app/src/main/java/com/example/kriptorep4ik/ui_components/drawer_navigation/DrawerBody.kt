package com.example.kriptorep4ik.ui_components.drawer_navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerBody() {
    LazyColumn(modifier = Modifier.fillMaxWidth()) { items(5) {
        Text(modifier = Modifier.padding(10.dp), text = "Menu item ${it}")
    }
    }
}