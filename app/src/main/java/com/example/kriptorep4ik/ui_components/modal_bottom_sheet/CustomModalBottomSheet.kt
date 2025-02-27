package com.example.kriptorep4ik.ui_components.modal_bottom_sheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kriptorep4ik.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomModalBottomSheet(showBottomSheet: Boolean, onDismissRequest: () -> Unit) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest                                                         //если смахнет или нажмет вне окна
    ) {
        Column(modifier = Modifier.offset(y=-20.dp)) {
            Row {
                TextButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.Gray
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(R.drawable.kurs_valut),
                            contentDescription = "kurs_valut",
                            modifier = Modifier.size(35.7.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "Все курсы валют",
                            fontSize = 20.sp,
                            color = Color.Black,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )

                    }
                }
            }

            Row {
                TextButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.Gray
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(R.drawable.grafic_torgov),
                            contentDescription = "grafic_torgov",
                            modifier = Modifier.size(35.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "График торгов",
                            fontSize = 20.sp,
                            color = Color.Black,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }

            Row {
                TextButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.Gray
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(R.drawable.kroptovaluta),
                            contentDescription = "kroptovaluta",
                            modifier = Modifier.size(38.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "Криптовалюта",
                            fontSize = 20.sp,
                            color = Color.Black,
                            style = TextStyle(fontWeight = FontWeight.Bold)

                        )
                    }
                }
            }

            Row {
                TextButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.Gray
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(R.drawable.arhive_valut),
                            contentDescription = "arhive_valut",
                            modifier = Modifier.size(35.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "Архив валют",
                            fontSize = 20.sp,
                            color = Color.Black,
                            style = TextStyle(fontWeight = FontWeight.Bold)

                        )
                    }
                }
            }


            Row {
                TextButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.Gray
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(R.drawable.akcii),
                            contentDescription = "akcii",
                            modifier = Modifier.size(35.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "Акции",
                            fontSize = 20.sp,
                            color = Color.Black,
                            style = TextStyle(fontWeight = FontWeight.Bold)

                        )
                    }
                }
            }


            Row {
                TextButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.Gray
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(R.drawable.rekamyoff),
                            contentDescription = "rekamyoff",
                            modifier = Modifier.size(35.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "Отключить рекламу",
                            fontSize = 20.sp,
                            color = Color.Black,
                            style = TextStyle(fontWeight = FontWeight.Bold)

                        )
                    }
                }
            }

            Row {
                TextButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.Gray
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(R.drawable.nastroiki),
                            contentDescription = "nastroiki",
                            modifier = Modifier.size(35.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "Настройки",
                            fontSize = 20.sp,
                            color = Color.Black,
                            style = TextStyle(fontWeight = FontWeight.Bold)

                        )
                    }
                }
            }
        }
    }
}
