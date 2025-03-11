package com.example.kriptorep4ik.parse_data.resources

data class ResourcesModel(
    val name: String,
    val additionalName: String,
    val price: String,
    val dayChange: String,
    val percent: String,
    val YTD: String,
    val YoY: String,
    val date: String
)
