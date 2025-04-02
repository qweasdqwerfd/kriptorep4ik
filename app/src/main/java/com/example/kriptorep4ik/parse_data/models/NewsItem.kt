package com.example.kriptorep4ik.parse_data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsItem(
    @SerialName("ID")
    val id: Int,

    val title: String,
    val description: String,
    val url: String? = null,
    val author: String? = null,
    val country: String,
    val category: String? = null,

    // Все поля, которые могут быть в JSON
    val image: String? = null,
    val importance: Int? = null,
    val date: String,
    val expiration: String? = null,
    val html: String? = null,
    val type: String? = null
)
