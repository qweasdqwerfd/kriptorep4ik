package com.example.kriptorep4ik.visual.instruments.bottom_navigation

import com.example.kriptorep4ik.R

sealed class BottomItem(
    val title: String,
    val iconId: Int,
    val route: String
) {
    object PrimaryScreen1: BottomItem("Главная", R.drawable.primary, "primary")
    object ExchangeScreen2: BottomItem("Обменники", R.drawable.exchange, "exchange")
    object ConvertScreen3: BottomItem("Ковертер", R.drawable.convert, "convert")
    object ResScreen4: BottomItem("Ресурсы", R.drawable.res, "res")
}