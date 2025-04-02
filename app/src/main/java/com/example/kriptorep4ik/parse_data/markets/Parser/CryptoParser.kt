package com.example.kriptorep4ik.parse_data.markets.Parser

import android.util.Log
import com.example.kriptorep4ik.parse_data.markets.MarketParser
import com.example.kriptorep4ik.parse_data.markets.parseData
import com.example.kriptorep4ik.parse_data.models.MarketModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class CryptoParser: MarketParser {

    override suspend fun getWeb(): Map<String, List<MarketModel>> {

        try {
            val doc = withContext(Dispatchers.IO) {
                Jsoup.connect("https://tradingeconomics.com/crypto").get()
            }

            val name = doc.select("b")
            val price = doc.select("td#p.datatable-item")
            val dayChange = doc.select("td#nch.datatable-item")
            val percent = doc.select("td#pch.datatable-item")
            val date = doc.select("td#date.datatable-item")

            val list = mapOf(
                "Crypto" to parseData(name, price, dayChange, percent, date, 0, 20),
                "BTC" to parseData(name, price, dayChange, percent, date, 20, 25),
                "ETH" to parseData(name, price, dayChange, percent, date, 45, 25),
            )

            return list

        } catch (e: Exception) {
            Log.e("parser", "Ошибка в CryptoParser getWeb():", e)
            throw e
        }
    }
}