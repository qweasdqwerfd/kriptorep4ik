package com.example.kriptorep4ik.ui_components.modal_bottom_sheet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
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
        Column(modifier = Modifier.padding(bottom = 30.dp)) {

            Row(
                horizontalArrangement = Arrangement.Absolute.Left) {

                Button(
                    onClick = {},
                    enabled = true,
                    colors = ButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.DarkGray,
                        disabledContentColor = Color.Gray)
                ) {
                    Image(
                        painter = painterResource(R.drawable.kurs_valut),
                        contentDescription = "kurs_valut",
                        Modifier
                            .size(40.dp)
                            .padding(end = 5.dp)
                    )

                    Text(
                        text = "Все курсы валют",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        color = Color.Black
                    )

                }



        }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.grafic_torgov),
                    contentDescription = "grafic_torgov",
                    Modifier
                        .size(40.dp)
                        .padding(start = 10.dp)
                )
                Text(
                    text = "График торгов",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    textAlign = TextAlign.Start
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.kroptovaluta),
                    contentDescription = "kroptovaluta",
                    Modifier
                        .size(40.dp)
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Криптовалюта",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    textAlign = TextAlign.Start
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.arhive_valut),
                    contentDescription = "arhive_valut",
                    Modifier
                        .size(40.dp)
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Архив валют",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    textAlign = TextAlign.Start
                )
            }


            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.akcii),
                    contentDescription = "akcii",
                    Modifier
                        .size(40.dp)
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Акции",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    textAlign = TextAlign.Start
                )
            }


            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.rekamyoff),
                    contentDescription = "rekamyoff",
                    Modifier
                        .size(40.dp)
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Отключить рекламу",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    textAlign = TextAlign.Start
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.nastroiki),
                    contentDescription = "nastroiki",
                    Modifier
                        .size(40.dp)
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Настройки",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}