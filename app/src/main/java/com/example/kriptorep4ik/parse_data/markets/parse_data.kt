package com.example.kriptorep4ik.parse_data.markets

import com.example.kriptorep4ik.parse_data.models.AllMarketsModel
import org.jsoup.select.Elements

fun parseData(
    name: Elements,
    price: Elements,
    dayChange: Elements,
    percent: Elements,
    date: Elements,
    startIndex: Int,
    count: Int
): List<AllMarketsModel> {
    return (0 until count).map { i ->
        val index = startIndex + i
        AllMarketsModel(
            name = name.getOrNull(index)?.text() ?: "",
            price = price.getOrNull(i)?.text() ?: "",
            dayChange = dayChange.getOrNull(i)?.text() ?: "",
            percent = percent.getOrNull(i)?.text() ?: "",
            date = date.getOrNull(i)?.text() ?: ""
        )
    }
}