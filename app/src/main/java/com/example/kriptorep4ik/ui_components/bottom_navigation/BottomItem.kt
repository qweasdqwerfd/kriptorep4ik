package com.example.kriptorep4ik.ui_components.bottom_navigation

import com.example.kriptorep4ik.R

sealed class BottomItem(
    val title: String,
    val iconId: Int,
    val route: String
) {
    object CalendarScreen: BottomItem("Calendar", R.drawable.kalendar, "calendar")
    object MarketScreen: BottomItem("Markets", R.drawable.markets, "markets")
    object NewsScreen: BottomItem("News", R.drawable.newwwwww, "news")
    object AccountScreen: BottomItem("Account", R.drawable.account, "account")
}