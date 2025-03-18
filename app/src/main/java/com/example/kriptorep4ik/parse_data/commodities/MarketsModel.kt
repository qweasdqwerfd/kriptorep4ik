package com.example.kriptorep4ik.parse_data.commodities

import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

data class MarketsModel(
    val name: String,
    val additionalName: String,
    val price: String,
    val dayChange: String,
    val percent: String,
    val date: String
)

/**
 * Метод для подключения с корректными заголовками
 */
fun fetchDocumentWithHeaders(url: String): Document {
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