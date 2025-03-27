package com.example.kriptorep4ik.parse_data.markets

import com.example.kriptorep4ik.parse_data.models.AllMarketsModel

suspend fun getAllMarkets(): Map<String, Map<String, List<AllMarketsModel>>> {
    val parsers: List<Pair<String, MarketParser>> = listOf(
        "Currencies" to CurrenciesParser(),

    )

    val result = mutableMapOf<String, Map<String, List<AllMarketsModel>>>()

    for ((name, parser) in parsers) {
        result[name] = parser.getWeb()
    }

    return result
}
