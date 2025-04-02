package com.example.kriptorep4ik.parse_data.markets.Parser

import android.util.Log
import com.example.kriptorep4ik.parse_data.markets.MarketParser
import com.example.kriptorep4ik.parse_data.markets.parseData
import com.example.kriptorep4ik.parse_data.models.MarketModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class BondsParser: MarketParser {

    override suspend fun getWeb(): Map<String, List<MarketModel>> {

        try {
            val doc = withContext(Dispatchers.IO) {
                Jsoup.connect("https://tradingeconomics.com/bonds").get()
            }

            val name = doc.select("b")
            val price = doc.select("td#p.datatable-item")
            val dayChange = doc.select("td#nch.datatable-item")
            val percent = doc.select("td.datatable-item.datatable-heatmap.d-none.d-md-table-cell")
            val date = doc.select("td#date.datatable-item")

            val list = mapOf(
                "Major10Y" to parseData(name, price, dayChange, percent, date, 0, 21),
                "Europe" to parseData(name, price, dayChange, percent, date, 21, 28),
                "America" to parseData(name, price, dayChange, percent, date, 49, 6),
                "Asia" to parseData(name, price, dayChange, percent, date, 55, 14),
                "Australia" to parseData(name, price, dayChange, percent, date, 69, 2),
                "Africa" to parseData(name, price, dayChange, percent, date, 71, 4),
            )

            return list

        } catch (e: Exception) {
            Log.e("parser", "Ошибка в BondsParser getWeb():", e)
            throw e
        }
    }
}