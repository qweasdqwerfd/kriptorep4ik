package com.example.kriptorep4ik.parse_data.commodities

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MetalsParser {

    suspend fun getWeb(): List<MarketsModel> {
        return withContext(Dispatchers.IO) {
            try {
                delay(Random.nextLong(1000, 3000)) // Случайная задержка (имитация пользователя)

                val doc = fetchDocumentWithHeaders("https://tradingeconomics.com/commodities")


                if (!doc.select("td#p.datatable-item").isNotEmpty()) {
                    Log.e("mylog", "Error: Data not found or structure changed")
                    Log.e("mylog", "Received HTML: ${doc.body().html().take(500)}") // Для анализа
                    return@withContext emptyList()
                }


                val name = doc.select("b")
                val additionalName = doc.select("div[style*=font-size: 10px]")
                val price = doc.select("td#p.datatable-item")
                val dayChange = doc.select("td#nch.datatable-item")
                val percent = doc.select("td#pch.datatable-item")
                val date = doc.select("td#date")

                val resourcesMetalsList = mutableListOf<MarketsModel>()

                var ind_name = 18
                var ind_additionalName = 14
                var ind_price = 14
                var ind_dayChange = 14
                var ind_percent = 14
                var ind_date = 14


                for (ind in 0 until 10) {
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
                        resourcesMetalsList.add(tempContainer)
                    }

                }


                return@withContext resourcesMetalsList

            } catch (e: Exception) {
                Log.e("mylog", "Error fetching metals data: ${e.message}")
                return@withContext emptyList()
            }
        }
    }
}
