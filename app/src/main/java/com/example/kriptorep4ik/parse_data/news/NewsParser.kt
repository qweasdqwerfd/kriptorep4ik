package com.example.kriptorep4ik.parse_data.news

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class NewsParser {

    suspend fun getWeb() {

        val doc = withContext(Dispatchers.IO) {
            Jsoup.connect("https://tradingeconomics.com/stream").get()
        }

        val name = doc.select("b")
        val county = doc.select("a.badge.small.te-stream-country")
        val category = doc.select("a.badge.small.te-stream-category")
        val text = doc.select("span.te-stream-item-description")
        val date = doc.select("small")

        Log.d("check", category.text())


    }

}