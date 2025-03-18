package com.example.kriptorep4ik.parse_data.commodities

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ElectricityParser {

    suspend fun getWeb(): List<MarketsModel> {
        return withContext(Dispatchers.IO) {

            try {
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

                val resourcesElectricity = mutableListOf<MarketsModel>()

                var ind_name = 92
                var ind_additionalName = 88
                var ind_price = 88
                var ind_dayChange = 88
                var ind_percent = 88
                var ind_date = 88


                for (ind in 0 until 5) {
                    if (name.size > ind_name &&
                        additionalName.size > ind_additionalName &&
                        price.size > ind_price &&
                        dayChange.size > ind_dayChange &&
                        percent.size > ind_percent &&
                        date.size > ind_date
                    ) {
                        val tempContainer = MarketsModel(
                            name = name[ind_name++].text(),
                            additionalName = additionalName[ind_additionalName++].text(),
                            price = price[ind_price++].text(),
                            dayChange = dayChange[ind_dayChange++].text(),
                            percent = percent[ind_percent++].text(),
                            date = date[ind_date++].text()
                        )

                        resourcesElectricity.add(tempContainer)
                    }
                }
                return@withContext resourcesElectricity

            } catch (e: Exception) {
                Log.e("mylog", "Error fetching Electricity data: ${e.message}")
                return@withContext emptyList()
            }
        }
    }
}