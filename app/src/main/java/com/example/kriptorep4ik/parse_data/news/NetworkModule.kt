package com.example.kriptorep4ik.parse_data.news

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object NetworkModule {
    val jsonParser = Json {
        ignoreUnknownKeys = true
        isLenient = true
        explicitNulls = false
        coerceInputValues = true // Дополнительная защита
    }

    // Общий HTTP-клиент
    val httpClient by lazy {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(jsonParser)
            }
        }
    }
}