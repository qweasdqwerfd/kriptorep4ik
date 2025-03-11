package com.example.kriptorep4ik.parse_data.currency

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class ParserCurrency {


    suspend fun getWeb(): List<CurrencyModel> {
        return withContext(Dispatchers.IO) {
            try {
                val doc: Document = Jsoup.connect("https://finance.rambler.ru/currencies/").get()
                val letterCode: Elements = doc.select("span.ZUUpr1jh.Vf1AWW7q")
                val unit: Elements = doc.select("span.PjocFlvi")
                val rate: Elements = doc.select("span._ZXx92_y")
                val currency: Elements = doc.select("span.OYTwr2Ke")
                val date: String? = doc.select("span.PsQREKPJ").text()

                // Собираем все элементы, которые могут содержать изменения
                val changeElements: Elements = doc.select("span.M6nt2YLN")

                val allChanges = mutableListOf<String>()
                for (element in changeElements) {

                    when {
                        element.hasClass("uMrkuHxH") -> allChanges.add(element.text()) // Положительное изменение
                        element.hasClass("GlHvWI7G") -> allChanges.add(element.text()) // Отрицательное изменение
                    }
                }

                val additionalParserList: MutableList<CurrencyModel> = mutableListOf()

                var percentageIndex = 10
                var letterIndex = 0
                var unitIndex = 0
                var rateIndex = 22
                var currencyIndex = 0

                while (percentageIndex < allChanges.size && letterIndex < letterCode.size
                    && unitIndex < unit.size && rateIndex < rate.size && currencyIndex < currency.size
                ) {

                    val tempContainer = CurrencyModel(
                        letterCode = letterCode[letterIndex].text(),
                        change = allChanges[percentageIndex],
                        percentageChange = allChanges[percentageIndex + 1],
                        currency = currency[currencyIndex].text(),
                        rate = rate[rateIndex].text(),
                        unit = unit[unitIndex].text(),
                        date = date.toString()
                    )
                    additionalParserList.add(tempContainer)

                    percentageIndex += 2
                    letterIndex++
                    unitIndex++
                    rateIndex++
                    currencyIndex++
                }

                return@withContext additionalParserList
            } catch (e: Exception) {
                Log.e("mylog", "error: ${e.message}")
                return@withContext emptyList()
            }
        }
    }
}
