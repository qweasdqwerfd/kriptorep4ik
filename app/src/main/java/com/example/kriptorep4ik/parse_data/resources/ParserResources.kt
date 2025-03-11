package com.example.kriptorep4ik.parse_data.resources

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class ParserResources {

    suspend fun getWeb(): List<ResourcesModel> {
        return withContext(Dispatchers.IO) {
            try {

                val doc: org.jsoup.nodes.Document? =
                    Jsoup.connect("https://tradingeconomics.com/commodities").get()
                val name: Elements? = doc?.select("b")
                val additionalName: Elements? = doc?.select("div[style*=font-size: 10px]")
                val price: Elements? = doc?.select("td#p.datatable-item")
                val dayChange: Elements? = doc?.select("td#nch.datatable-item")
                val percent: Elements? = doc?.select("td#pch.datatable-item")
                val YTD_YoY: Elements? =
                    doc?.select("td.datatable-item.datatable-heatmap.d-none.d-md-table-cell")
                val date: Elements? = doc?.select("td#date")

                val ResourcesEnergyList: MutableList<ResourcesModel> = mutableListOf()

                var ind_YTD_YoY = 0
                var ind_name = 4

                if (name != null && price != null && dayChange != null && percent != null && YTD_YoY != null && date != null) {
                    for (ind in 0 until 14) {


                        val tempContainer = ResourcesModel(
                            name[ind_name].text(),
                            additionalName?.get(ind)?.text().toString(),
                            price[ind].text(),
                            dayChange[ind].text(),
                            percent[ind].text(),
                            YTD_YoY[ind_YTD_YoY].text(),
                            YTD_YoY[ind_YTD_YoY + 1].text(),
                            date[ind].text()
                        )

//                        println(
//                            "\"Name: $testName, additionalName: $testAdditionalName, Price: $testPrice, " +
//                                    "Day Change: $testDayChange, Percent: $testPercent, " +
//                                    "YTD: $testYTD, YoY: $testYoY, Date: $testDate\""
//                        )

                        ResourcesEnergyList.add(tempContainer)

                        ind_name++
                        ind_YTD_YoY += 2
                    }
                }

                return@withContext ResourcesEnergyList

            } catch (e: Exception) {
                Log.e("mylog", "error: ${e.message}")
                return@withContext emptyList()
            }
        }
    }
}