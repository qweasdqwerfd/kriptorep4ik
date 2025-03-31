package com.example.kriptorep4ik.parse_data.markets

import com.example.kriptorep4ik.parse_data.models.MarketModel

interface MarketParser {
    suspend fun getWeb(): Map<String, List<MarketModel>>
}