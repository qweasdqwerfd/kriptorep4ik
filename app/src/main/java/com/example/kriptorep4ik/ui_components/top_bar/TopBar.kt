package com.example.kriptorep4ik.ui_components.top_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel
import com.example.kriptorep4ik.parse_data.models.AllMarketsModel
import com.example.kriptorep4ik.parse_data.models.CommoditiesModel
import com.example.kriptorep4ik.ui_components.screens.markets.MarketsTabs
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    viewModelList: List<CurrencyModel>,
    commoditiesStateCurrency: Map<String, List<CommoditiesModel>>,
    currenciesList: Map<String, Map<String, List<AllMarketsModel>>>,
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
                Text(
                    text = when (currentRoute) {
                        "calendar" -> "Главная"
                        "exchange" -> "Обменники"
                        "convert" -> "Конвертер"
                        "addition" -> "Настройки валют"
                        "allScreen" -> "Настройки валют"
                        "elected" -> "Настройки валют"
                        else -> {
                            "Ресурсы"
                        }
                    }
                )
            },


            navigationIcon = {
                if (currentRoute == "addition" || currentRoute == "allScreen" || currentRoute == "elected") {
                    IconButton(onClick = { navController.navigate("calendar") }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "назад",
                            tint = White
                        )
                    }
                }
            },

            actions = {
                if (currentRoute == "addition" || currentRoute == "allScreen" || currentRoute == "elected") {
                    Button(
                        onClick = { /* Обработка нажатия */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.MainInterface)
                        )
                    ) {
                        Text(
                            text = "Готово",
                            fontSize = 17.sp,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                    }
                }
                when (currentRoute) {

                    "calendar" -> {
                        Button(
                            onClick = { navController.navigate("addition") },
                            colors = ButtonColors(
                                containerColor = colorResource(R.color.MainInterface),
                                contentColor = White,
                                disabledContainerColor = colorResource(R.color.MainInterface),
                                disabledContentColor = colorResource(R.color.MainInterface)
                            ),
                        ) {
                            Text(
                                text = "Изменить",
                                fontSize = 17.sp,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }
                    }

                    "exchange" -> {
                        IconButton(onClick = {}) {
                            Image(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.search),
                                contentDescription = ""
                            )
                        }

                        IconButton(onClick = {}) {
                            Image(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.sort),
                                contentDescription = ""
                            )
                        }
                    }

                    "convert" -> {
                        IconButton(onClick = {}) {
                            Image(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.pen),
                                contentDescription = ""
                            )
                        }

                        IconButton(onClick = {}) {
                            Image(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.repost),
                                contentDescription = ""
                            )
                        }
                    }

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
            MarketsTabs(commoditiesStateCurrency, currenciesList)
        }

    }

}