package com.example.kriptorep4ik.visual.instruments.top_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
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
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kriptorep4ik.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    snackBarHostState: SnackbarHostState,
) {
    var currentRoute by remember { mutableStateOf("primary") }



    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            currentRoute = backStackEntry.destination.route ?: "Ресурсы"
        }
    }


    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Gray),


        title = {
            Text(

                text = when (currentRoute) {
                    "primary" -> "Главная"
                    "exchange" -> "Обменники"
                    "convert" -> "Конвертер"
                    else -> {
                        "Ресурсы"
                    }
                }
            )
        },

        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
        },
        actions = {
            when (currentRoute) {
                "primary" -> {
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                val result = snackBarHostState.showSnackbar(
                                    message = "Вы изменили!",
                                    actionLabel = "Отменить",
                                    duration = SnackbarDuration.Short
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    coroutineScope.launch {
                                        snackBarHostState.showSnackbar("Действие отменено")
                                    }
                                }
                            }
                        },
                        colors = ButtonColors(
                            containerColor = Gray,
                            contentColor = Black,
                            disabledContainerColor = Gray,
                            disabledContentColor = Gray
                        ),
                    ) {
                        Text(
                            text = "Изменить",
                            fontSize = 17.sp,
                            fontStyle = FontStyle.Normal
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

                "res" -> {
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
}