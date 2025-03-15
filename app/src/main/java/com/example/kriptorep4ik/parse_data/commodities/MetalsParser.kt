package com.example.kriptorep4ik.parse_data.commodities

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class MetalsParser {

    suspend fun getWeb() {
        return withContext(Dispatchers.IO) {

            val doc = fetchDocumentWithHeaders("https://tradingeconomics.com/commodities")

            val additionalName = doc.select("div[style*=font-size: 10px]")
            val price = doc.select("td#p.datatable-item")
            val dayChange = doc.select("td#nch.datatable-item")
            val percent = doc.select("td#pch.datatable-item")
            val YTD_YoY = doc.select("td.datatable-item.datatable-heatmap.d-none.d-md-table-cell")
            val date = doc.select("td#date")



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
