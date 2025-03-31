package com.example.kriptorep4ik.parse_data.markets

import com.example.kriptorep4ik.parse_data.models.MarketModel
import org.jsoup.select.Elements

fun parseData(
    name: Elements,
    price: Elements,
    dayChange: Elements,
    percent: Elements,
    date: Elements,
    startIndex: Int,
    count: Int
): List<MarketModel> {
    return (startIndex until startIndex + count).map { i ->
        val index = 4 + i
        MarketModel(
            name = name.getOrNull(index)?.text() ?: "",
            price = price.getOrNull(i)?.text() ?: "",
            dayChange = dayChange.getOrNull(i)?.text() ?: "",
            percent = percent.getOrNull(i)?.text() ?: "",
            date = date.getOrNull(i)?.text() ?: ""
        )
    }
}