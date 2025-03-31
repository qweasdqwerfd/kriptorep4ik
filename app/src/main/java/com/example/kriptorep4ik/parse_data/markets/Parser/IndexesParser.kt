package com.example.kriptorep4ik.parse_data.markets.Parser

import android.util.Log
import com.example.kriptorep4ik.parse_data.markets.MarketParser
import com.example.kriptorep4ik.parse_data.markets.parseData
import com.example.kriptorep4ik.parse_data.models.MarketModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class IndexesParser: MarketParser {

    override suspend fun getWeb(): Map<String, List<MarketModel>> {

        try {
            val doc = withContext(Dispatchers.IO) {
                Jsoup.connect("https://tradingeconomics.com/stocks").get()
            }


            val name = doc.select("b")
            val additionalName = doc.select("div[style*=font-size: 10px]")
            val price = doc.select("td#p.datatable-item")
            val dayChange = doc.select("td#nch.datatable-item")
            val percent = doc.select("td#pch.datatable-item")
            val date = doc.select("td#date")

            val list = mapOf(
                "Major" to parseData(name, price, dayChange, percent, date, 0, 23),
                "Europe" to parseData(name, price, dayChange, percent, date, 23, 45),
                "America" to parseData(name, price, dayChange, percent, date, 68, 16),
                "Asia" to parseData(name, price, dayChange, percent, date, 84, 33),
                "Australia" to parseData(name, price, dayChange, percent, date, 117, 4),
                "Africa" to parseData(name, price, dayChange, percent, date, 121, 15),
            )

            return list


        } catch (e: Exception) {
            Log.e("check", "Ошибка в getWeb():", e)
            throw e
        }
    }
}