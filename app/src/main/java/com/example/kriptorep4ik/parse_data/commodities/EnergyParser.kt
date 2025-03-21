package com.example.kriptorep4ik.parse_data.commodities

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class EnergyParser {

    suspend fun getWeb(): List<MarketsModel> {
        return withContext(Dispatchers.IO) {
            try {
                delay(Random.nextLong(1000, 3000)) // Случайная задержка (имитация пользователя)

                val doc = fetchDocumentWithHeaders("https://tradingeconomics.com/commodities")

                // Проверка на корректность структуры страницы
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

                val resourcesEnergyList = mutableListOf<MarketsModel>()

                if (name.size >= 18 && price.size >= 14 && dayChange.size >= 14 &&
                    percent.size >= 14 && date.size >= 14
                ) {
                    var ind_name = 4

                    for (ind in 0 until 14) {
                        val tempContainer = MarketsModel(
                            name[ind_name].text(),
                            additionalName[ind].text(),
                            price[ind].text(),
                            dayChange[ind].text(),
                            percent[ind].text(),
                            date[ind].text()
                        )

                        resourcesEnergyList.add(tempContainer)

                        ind_name++

                    }
                }

                return@withContext resourcesEnergyList

            } catch (e: Exception) {
                Log.e("mylog", "Error fetching energy data: ${e.message}")
                return@withContext emptyList()
            }
        }
    }


}
