package com.example.kriptorep4ik.parse_data.commodities

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
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
                val YTD_YoY = doc.select("td.datatable-item.datatable-heatmap.d-none.d-md-table-cell")
                val date = doc.select("td#date")

                val resourcesEnergyList = mutableListOf<MarketsModel>()

                if (name.size >= 18 && price.size >= 14 && dayChange.size >= 14 &&
                    percent.size >= 14 && YTD_YoY.size >= 28 && date.size >= 14
                ) {
                    var ind_YTD_YoY = 0
                    var ind_name = 4

                    for (ind in 0 until 14) {
                        val tempContainer = MarketsModel(
                            name[ind_name].text(),
                            additionalName[ind].text(),
                            price[ind].text(),
                            dayChange[ind].text(),
                            percent[ind].text(),
                            YTD_YoY[ind_YTD_YoY].text(),
                            YTD_YoY[ind_YTD_YoY + 1].text(),
                            date[ind].text()
                        )

                        resourcesEnergyList.add(tempContainer)

                        ind_name++
                        ind_YTD_YoY += 2

                        Log.d("qweasdqwe", tempContainer.toString())
                    }
                } else {
                    Log.e("mylog", "One or more elements are missing or insufficient")
                }

                return@withContext resourcesEnergyList

            } catch (e: Exception) {
                Log.e("mylog", "Error fetching data: ${e.message}")
                return@withContext emptyList()
            }
        }
    }

    /**
     * Метод для подключения с корректными заголовками
     */
    private fun fetchDocumentWithHeaders(url: String): Document {
        return Jsoup.connect(url)
            .method(Connection.Method.GET)
            .header("User-Agent", generateRandomUserAgent())
            .header("Referer", "https://www.google.com/")
            .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9")
            .timeout(15000) // Увеличенное время ожидания
            .ignoreHttpErrors(true)
            .get()
    }

    /**
     * Генерация случайных User-Agent строк
     */
    private fun generateRandomUserAgent(): String {
        val userAgents = listOf(
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36",
            "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36",
            "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/537.36",
            "Mozilla/5.0 (Android 11; Mobile; rv:89.0) Gecko/89.0 Firefox/89.0"
        )
        return userAgents.random()
    }
}
