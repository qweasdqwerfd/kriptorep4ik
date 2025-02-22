package com.example.kriptorep4ik.visual.instruments.bottom_navigation

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.ui.theme.hz


@Composable
fun BottomNavigation(navController: NavController) {

    val listItems = listOf(
        BottomItem.PrimaryScreen1,
        BottomItem.ExchangeScreen2,
        BottomItem.ConvertScreen3,
        BottomItem.ResScreen4,
    )

    NavigationBar(
        modifier = Modifier.offset(y = 15.dp),
        containerColor = Color.Gray
    ) {

        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        listItems.forEach { item ->

            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        modifier = Modifier.size(20.dp),
                        contentDescription = "Icon"
                    )
                },
                label = { Text(text = item.title, fontSize = 9.sp) },

                colors = NavigationBarItemColors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = colorResource(id = R.color.MainInterface),
                    unselectedIconColor = colorResource(id = R.color.MainInterface),
                    unselectedTextColor = colorResource(id = R.color.MainInterface),
                    selectedIndicatorColor = hz,
                    disabledIconColor = hz,
                    disabledTextColor = hz
                )
            )
        }

    }
}