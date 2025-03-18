package com.example.kriptorep4ik.ui_components.bottom_navigation

import com.example.kriptorep4ik.R

sealed class BottomItem(
    val title: String,
    val iconId: Int,
    val route: String
) {
    object PrimaryScreen1: BottomItem("Calendar", R.drawable.kalendar, "calendar")
    object ResScreen4: BottomItem("Markets", R.drawable.markets, "markets")
    object ExchangeScreen2: BottomItem("Обменники", R.drawable.exchange, "exchange")
    object ConvertScreen3: BottomItem("Ковертер", R.drawable.convert, "convert")
    object MenuScreen5: BottomItem("Меню", R.drawable.menu, "menu")
}