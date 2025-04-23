package com.example.kriptorep4ik.ui_components.top_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.models.MarketModel
import com.example.kriptorep4ik.ui_components.screens.markets.MarketsTabs
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    currenciesList: Map<String, Map<String, List<MarketModel>>>,
) {
    var currentRoute by remember { mutableStateOf("calendar") }



    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            currentRoute = backStackEntry.destination.route ?: "Ресурсы"
        }
    }


    Column {
        TopAppBar(


            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
                titleContentColor = White
            ),
            title = {
                Column {
                    Text(
                        text = "TRADING",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        modifier = Modifier
                            .offset(y=-11.dp),
                        text = "ECONOMICS",
                        color = colorResource(R.color.economicColor),
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                }
            },



            navigationIcon = {},
            actions = {
                when (currentRoute) {




                    "markets" -> {
                        IconButton(onClick = {}) {
                            Image(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.repost),
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        )

        if (currentRoute == "markets") {
            MarketsTabs(currenciesList)
        }

    }

}