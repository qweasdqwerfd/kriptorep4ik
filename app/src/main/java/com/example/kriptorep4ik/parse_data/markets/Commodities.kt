package com.example.kriptorep4ik.parse_data.markets

import android.util.Log
import com.example.kriptorep4ik.parse_data.models.CommoditiesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class Commodities {

    suspend fun getWeb(): Map<String, List<CommoditiesModel>> {
        return withContext(Dispatchers.IO) {
            try {
                val doc = Jsoup.connect("https://tradingeconomics.com/commodities").get()

                val name = doc.select("b")
                val additionalName = doc.select("div[style*=font-size: 10px]")
                val price = doc.select("td#p.datatable-item")
                val dayChange = doc.select("td#nch.datatable-item")
                val percent = doc.select("td#pch.datatable-item")
                val date = doc.select("td#date")

                // Список категорий и количества элементов в них
                val categories = listOf(
                    "Energy" to 14,
                    "Metals" to 10,
                    "Agricultural" to 23,
                    "Industrial" to 24,
                    "Livestock" to 8,
                    "Index" to 8,
                    "Electricity" to 5
                )

                val result = mutableMapOf<String, List<CommoditiesModel>>()
                var startIndex = 4 // Начальный индекс

                for ((categoryName, count) in categories) {
                    val list = parseData(name, additionalName, price, dayChange, percent, date, startIndex, count)
                    result[categoryName] = list
                    startIndex += count // Увеличиваем индекс для следующей категории
                }

                return@withContext result
            } catch (e: Exception) {
                Log.e("mylog", "Exception: ${e.message}")
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
    ): List<CommoditiesModel> {
        val resourcesList = mutableListOf<CommoditiesModel>()

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
                val tempContainer = CommoditiesModel(
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
