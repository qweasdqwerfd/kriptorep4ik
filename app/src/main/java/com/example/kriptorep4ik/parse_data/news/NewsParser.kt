package com.example.kriptorep4ik.parse_data.news

import android.util.Log
import com.example.kriptorep4ik.parse_data.models.NewsItem
import com.example.kriptorep4ik.parse_data.news.NetworkModule.httpClient
import com.example.kriptorep4ik.parse_data.news.NetworkModule.jsonParser
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.bodyAsText


suspend fun fetchNews(): List<NewsItem> {
    return try {
        val rawJson = httpClient.get("https://tradingeconomics.com/ws/stream.ashx") {
            url {
                parameters.append("start", "0")
                parameters.append("size", "20")
            }
            headers {
                append("Accept", "application/json")
                append("User-Agent", "MyApp/1.0")
            }
        }.bodyAsText()

//        Log.d("JSON_RESPONSE", "Raw JSON (${rawJson.length} chars): ${rawJson.take(100)}...")

//        // Проверка валидности JSON
//        if (rawJson.isBlank() || !rawJson.startsWith("[")) {
//            Log.e("JSON_ERROR", "Invalid JSON format")
//            return emptyList()
//        }

        jsonParser.decodeFromString<List<NewsItem>>(rawJson).also {
//            Log.d("PARSE_RESULT", "Successfully parsed ${it.size} items")
        }
    } catch (e: Exception) {
        Log.e("FETCH_ERROR", "Failed to fetch news", e)
        emptyList()
    }
}