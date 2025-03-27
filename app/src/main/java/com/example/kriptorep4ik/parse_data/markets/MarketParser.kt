package com.example.kriptorep4ik.parse_data.markets

import com.example.kriptorep4ik.parse_data.models.AllMarketsModel

interface MarketParser {
    suspend fun getWeb(): Map<String, List<AllMarketsModel>>
}