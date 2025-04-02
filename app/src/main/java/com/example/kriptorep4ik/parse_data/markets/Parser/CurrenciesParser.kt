package com.example.kriptorep4ik.parse_data.markets.Parser

import android.util.Log
import com.example.kriptorep4ik.parse_data.markets.MarketParser
import com.example.kriptorep4ik.parse_data.markets.parseData
import com.example.kriptorep4ik.parse_data.models.MarketModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class CurrenciesParser : MarketParser {

    override suspend fun getWeb(): Map<String, List<MarketModel>> {
        try {
            //!!
            val doc = withContext(Dispatchers.IO) {
                Jsoup.connect("https://tradingeconomics.com/currencies").get()
            }

            val name: Elements = doc.select("b")
            val price: Elements = doc.select("td#p.datatable-item")
            val dayChange: Elements = doc.select("td#nch.datatable-item")
            val percent: Elements = doc.select("td#pch.datatable-item")
            val date: Elements = doc.select("td#date.datatable-item")


            val list = mapOf(
                "Major" to parseData(name, price, dayChange, percent, date, 0, 27),
                "Europe" to parseData(name, price, dayChange, percent, date, 27, 21),
                "America" to parseData(name, price, dayChange, percent, date, 48, 27),
                "Asia" to parseData(name, price, dayChange, percent, date, 75, 46),
                "Australia" to parseData(name, price, dayChange, percent, date, 121, 5),
                "Africa" to parseData(name, price, dayChange, percent, date, 126, 42)
            )

            return list
        } catch (e: Exception) {
            Log.e("parser", "Ошибка в CurrenciesParser getWeb():", e)
            throw e
        }
    }
}


