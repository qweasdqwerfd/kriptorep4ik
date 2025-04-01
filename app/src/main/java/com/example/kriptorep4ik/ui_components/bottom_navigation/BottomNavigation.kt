package com.example.kriptorep4ik.ui_components.bottom_navigation

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
import com.example.kriptorep4ik.ui_components.instruments.hz


@Composable
fun BottomNavigation(navController: NavController, onBottomNavClick: () -> Unit) {

    val listItems = listOf(
        BottomItem.CalendarScreen,
        BottomItem.MarketScreen,
        BottomItem.NewsScreen,
        BottomItem.AccountScreen,
    )

    NavigationBar(
        containerColor = colorResource(R.color.MainInterface),
    ) {

        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        listItems.forEach { item ->

            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (item.route == "menu") {
                        onBottomNavClick()
                    } else {
                        navController.navigate(item.route)
                    }
                          },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        modifier = Modifier.size(20.dp),
                        contentDescription = "Icon",
                    )
                },
                label = { Text(text = item.title, fontSize = 9.sp) },

                colors = NavigationBarItemColors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White,
                    selectedIndicatorColor = hz,
                    disabledIconColor = hz,
                    disabledTextColor = hz
                )
            )
        }
    }
}