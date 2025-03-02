package com.example.kriptorep4ik.logic

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class JsoupParser {

    suspend fun getWeb(): List<CurrencyRateModel> {
        return withContext(Dispatchers.IO) {

            try {
                val doc: Document = Jsoup.connect("https://www.cbr.ru/currency_base/daily/").get()
                val tables: Elements = doc.getElementsByTag("tr")
                val currencyRatesContainer = mutableListOf<CurrencyRateModel>()

                for (i in 1 until  tables.size) {
                    val our_table: Element = tables[i]
                    val temp: Elements = our_table.children()

                    val letter_code: Element = temp[1]
                    val rate: Element = temp[temp.size - 1]

                    val currency: String = if (temp.size == 6) {
                        "${temp[3].text()} ${temp[4].text()}"

                    } else {

                        temp[3].text()
                    }
                    val currencyRateModel = CurrencyRateModel(
                        currency = currency,
                        letter_code = letter_code.text(),
                        rate = rate.text()
                    )
                    currencyRatesContainer.add(currencyRateModel)

                    Log.d("mylog", our_table.text())
                    Log.d("mylog", letter_code.text())
                    Log.d("mylog", currency)
                    Log.d("mylog", rate.text())

                }

                currencyRatesContainer

            } catch (e: Exception) {
                Log.e("mylog", "Error in getWeb: ${e.message}", e)
                emptyList()
            }
        }
    }
}