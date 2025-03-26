package com.example.kriptorep4ik.parse_data.commodities

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class Commodities {

    suspend fun getWeb(): Map<String, List<MarketsModel>> {
        return withContext(Dispatchers.IO) {
            try {
                val doc = Jsoup.connect("https://tradingeconomics.com/commodities").get()

                // Проверка на корректность структуры страницы
                if (!doc.select("td#p.datatable-item").isNotEmpty()) {
                    Log.e("mylog", "Error: Data not found or structure changed")
                    Log.e("mylog", "Received HTML: ${doc.body().html().take(500)}")
                    return@withContext emptyMap()
                }

                val name = doc.select("b")
                val additionalName = doc.select("div[style*=font-size: 10px]")
                val price = doc.select("td#p.datatable-item")
                val dayChange = doc.select("td#nch.datatable-item")
                val percent = doc.select("td#pch.datatable-item")
                val date = doc.select("td#date")

                // Списки для каждой категории
                val resourcesEnergyList = parseData(name, additionalName, price, dayChange, percent, date, startIndex = 4, count = 14)
                val resourcesMetalsList = parseData(name, additionalName, price, dayChange, percent, date, startIndex = 18, count = 10)
                val resourcesAgriculturalList = parseData(name, additionalName, price, dayChange, percent, date, startIndex = 28, count = 23)
                val resourcesIndustrialList = parseData(name, additionalName, price, dayChange, percent, date, startIndex = 51, count = 24)
                val resourcesLivestockList = parseData(name, additionalName, price, dayChange, percent, date, startIndex = 75, count = 8)
                val resourcesIndexList = parseData(name, additionalName, price, dayChange, percent, date, startIndex = 83, count = 8)
                val resourcesElectricityList = parseData(name, additionalName, price, dayChange, percent, date, startIndex = 92, count = 5)


                // Возвращаем данные в виде Map
                return@withContext mapOf(
                    "Energy" to resourcesEnergyList,
                    "Metals" to resourcesMetalsList,
                    "Agricultural" to resourcesAgriculturalList,
                    "Industrial" to resourcesIndustrialList,
                    "Livestock" to resourcesLivestockList,
                    "Index" to resourcesIndexList,
                    "Electricity" to resourcesElectricityList
                )
            } catch (e: Exception) {
                Log.e("mylog", "Error fetching data: ${e.message}")
                return@withContext emptyMap()
            }
        }
    }

    private fun parseData(
        name: Elements,
        additionalName: Elements,
        price: Elements,
        dayChange: Elements,
        percent: Elements,
        date: Elements,
        startIndex: Int,
        count: Int
    ): List<MarketsModel> {
        val resourcesList = mutableListOf<MarketsModel>()

        var ind_name = startIndex
        var ind_additionalName = startIndex - 4 // Примерное смещение
        var ind_price = startIndex - 4
        var ind_dayChange = startIndex - 4
        var ind_percent = startIndex - 4
        var ind_date = startIndex - 4

        for (ind in 0 until count) {
            if (name.size > ind_name &&
                additionalName.size > ind_additionalName &&
                price.size > ind_price &&
                dayChange.size > ind_dayChange &&
                percent.size > ind_percent &&
                date.size > ind_date
            ) {
                val tempContainer = MarketsModel(
                    name[ind_name++].text(),
                    additionalName[ind_additionalName++].text(),
                    price[ind_price++].text(),
                    dayChange[ind_dayChange++].text(),
                    percent[ind_percent++].text(),
                    date[ind_date++].text()
                )
                resourcesList.add(tempContainer)
            }
        }

        return resourcesList
    }
}
