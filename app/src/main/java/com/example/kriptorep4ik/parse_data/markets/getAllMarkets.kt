package com.example.kriptorep4ik.parse_data.markets

import com.example.kriptorep4ik.parse_data.markets.Parser.BondsParser
import com.example.kriptorep4ik.parse_data.markets.Parser.CommoditiesParser
import com.example.kriptorep4ik.parse_data.markets.Parser.CryptoParser
import com.example.kriptorep4ik.parse_data.markets.Parser.CurrenciesParser
import com.example.kriptorep4ik.parse_data.markets.Parser.IndexesParser
import com.example.kriptorep4ik.parse_data.models.MarketModel

suspend fun getAllMarkets(): Map<String, Map<String, List<MarketModel>>> {

    val parsers: List<Pair<String, MarketParser>> = listOf(
        "Commodities" to CommoditiesParser(),
        "Currencies" to CurrenciesParser(),
        "Indexes" to IndexesParser(),
        "Bonds" to BondsParser(),
        "Crypto" to CryptoParser()

    )

    val result = mutableMapOf<String, Map<String, List<MarketModel>>>()

    for ((name, parser) in parsers) {
        result[name] = parser.getWeb()

    }

    return result

}
