package com.example.kriptorep4ik.parse_data.markets.Parser

import android.util.Log
import com.example.kriptorep4ik.parse_data.markets.MarketParser
import com.example.kriptorep4ik.parse_data.markets.parseData
import com.example.kriptorep4ik.parse_data.models.MarketModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup


class CommoditiesParser : MarketParser {

    override suspend fun getWeb(): Map<String, List<MarketModel>> {

        try {
            val doc = withContext(Dispatchers.IO) {
                Jsoup.connect("https://tradingeconomics.com/commodities").get()
            }

            val name = doc.select("b")
            val price = doc.select("td#p.datatable-item")
            val dayChange = doc.select("td#nch.datatable-item")
            val percent = doc.select("td#pch.datatable-item")
            val date = doc.select("td#date")

            val list = mapOf(
                "Energy" to parseData(name, price, dayChange, percent, date, 0, 13),
                "Metals" to parseData(name, price, dayChange, percent, date, 13, 10),
                "Agricultural" to parseData(name, price, dayChange, percent, date, 23, 23),
                "Industrial" to parseData(name, price, dayChange, percent, date, 46, 24),
                "Livestock" to parseData(name, price, dayChange, percent, date, 70, 8),
                "Index" to parseData(name, price, dayChange, percent, date, 78, 8),
                "Electricity" to parseData(name, price, dayChange, percent, date, 86, 5)
            )

            return list

        } catch (e: Exception) {
            Log.e("parser", "Ошибка в CommoditiesParser getWeb():", e)
            throw e
        }
    }

}