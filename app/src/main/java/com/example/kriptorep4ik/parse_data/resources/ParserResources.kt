package com.example.kriptorep4ik.parse_data.resources

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class ParserResources {

    suspend fun getWeb(): List<ResourcesModel> {
        return withContext(Dispatchers.IO) {
            try {
                val doc = Jsoup.connect("https://tradingeconomics.com/commodities").get()
                val name = doc.select("b")
                val additionalName = doc.select("div[style*=font-size: 10px]")
                val price = doc.select("td#p.datatable-item")
                val dayChange = doc.select("td#nch.datatable-item")
                val percent = doc.select("td#pch.datatable-item")
                val YTD_YoY = doc.select("td.datatable-item.datatable-heatmap.d-none.d-md-table-cell")
                val date = doc.select("td#date")

                val resourcesEnergyList = mutableListOf<ResourcesModel>()

                // Проверяем, что все списки не пустые и содержат достаточно элементов
                if (name.size >= 18 && price.size >= 14 && dayChange.size >= 14 &&
                    percent.size >= 14 && YTD_YoY.size >= 28 && date.size >= 14
                ) {
                    var ind_YTD_YoY = 0
                    var ind_name = 4

                    for (ind in 0 until 14) {
                        val tempContainer = ResourcesModel(
                            name.getOrNull(ind_name)?.text() ?: "",
                            additionalName.getOrNull(ind)?.text() ?: "",
                            price.getOrNull(ind)?.text() ?: "",
                            dayChange.getOrNull(ind)?.text() ?: "",
                            percent.getOrNull(ind)?.text() ?: "",
                            YTD_YoY.getOrNull(ind_YTD_YoY)?.text() ?: "",
                            YTD_YoY.getOrNull(ind_YTD_YoY + 1)?.text() ?: "",
                            date.getOrNull(ind)?.text() ?: ""
                        )

                        resourcesEnergyList.add(tempContainer)

                        ind_name++
                        ind_YTD_YoY += 2
                    }
                } else {
                    Log.e("mylog", "One or more elements are missing or insufficient")
                }

                return@withContext resourcesEnergyList

            } catch (e: Exception) {
                Log.e("mylog", "error: ${e.message}")
                return@withContext emptyList()
            }
        }
    }
}