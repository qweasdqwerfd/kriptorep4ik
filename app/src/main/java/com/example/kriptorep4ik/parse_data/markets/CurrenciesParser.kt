package com.example.kriptorep4ik.parse_data.markets

import android.util.Log
import com.example.kriptorep4ik.parse_data.models.AllMarketsModel
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class CurrenciesParser : MarketParser {

    override suspend fun getWeb(): Map<String, List<AllMarketsModel>> {

        val doc = Jsoup.connect("https://tradingeconomics.com/currencies").get()
        val name: Elements = doc.select("b")
        val price: Elements = doc.select("td#p.datatable-item")
        val dayChange: Elements = doc.select("td#nch.datatable-item")
        val percent: Elements = doc.select("td#pch.datatable-item")
        val date: Elements = doc.select("td#date.datatable-item")

        val list = mapOf(
            "Major" to parseData(name, price, dayChange, percent, date, 4, 27),
            "Europe" to parseData(name, price, dayChange, percent, date, 31, 21),
            "America" to parseData(name, price, dayChange, percent, date, 52, 27),
            "Asia" to parseData(name, price, dayChange, percent, date, 79, 46),
            "Australia" to parseData(name, price, dayChange, percent, date, 125, 5),
            "Africa" to parseData(name, price, dayChange, percent, date, 130, 42)
        )

        Log.d("check", list.toString())

        return list

//            var ind_name = 4
//
//            //major
//            for (item in 0 until 27) {
////                Log.d("check", name[ind_name++].text())
////                Log.d("check", price[item].text())
////                Log.d("check", dayChange[item].text())
////                Log.d("check", percent[item].text())
//                Log.d("check", date[item].text())
//
//            }
    }



}

