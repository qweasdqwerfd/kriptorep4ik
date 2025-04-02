package com.example.kriptorep4ik.parse_data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kriptorep4ik.parse_data.markets.getAllMarkets
import com.example.kriptorep4ik.parse_data.models.MarketModel
import com.example.kriptorep4ik.parse_data.models.NewsItem
import com.example.kriptorep4ik.parse_data.news.fetchEconomy
import com.example.kriptorep4ik.parse_data.news.fetchMarkets
import com.example.kriptorep4ik.parse_data.news.fetchNews
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val _getAllMarketsState = MutableStateFlow<Map<String, Map<String, List<MarketModel>>>>(emptyMap())
    val getAllMarketsState: StateFlow<Map<String, Map<String, List<MarketModel>>>> get() = _getAllMarketsState

    private val _getNewsData = MutableStateFlow<List<NewsItem>>(emptyList())
    val getNewsData: StateFlow<List<NewsItem>> get() = _getNewsData

    private val _getEconomyData = MutableStateFlow<List<NewsItem>>(emptyList())
    val getEconomyData: StateFlow<List<NewsItem>> get() = _getEconomyData

    private val _getMarketsData = MutableStateFlow<List<NewsItem>>(emptyList())
    val getMarketsData: StateFlow<List<NewsItem>> get() = _getMarketsData


    init {
        loadGetAllMarkets()
        loadNewData()
        loadEconomyData()
        loadMarketsData()
    }

    private fun loadGetAllMarkets() {
        viewModelScope.launch {
            try {

                val tempData = getAllMarkets()
                _getAllMarketsState.value = tempData

            } catch (e: Exception) {
                Log.e("ViewModel", "Error load Markets data: ${e.message}")
            }
        }
    }



    fun loadNewData() {

        viewModelScope.launch {
            try {
                val tempData = fetchNews()

//                Log.d("NEWS_DEBUG", tempData.toString())

                _getNewsData.value = tempData

            } catch (e: Exception) {
                Log.e("LOAD_ERROR", "Error loadNewData", e)
            }
        }
    }

    fun loadEconomyData() {

        viewModelScope.launch {
            try {
                val tempData = fetchEconomy()
                _getEconomyData.value = tempData


            } catch (e: Exception) {
                Log.e("LOAD_ERROR", "Error loadEconomyData", e)
            }
        }
    }

    fun loadMarketsData() {

        viewModelScope.launch {
            try {
                val tempData = fetchMarkets()
                _getMarketsData.value = tempData


            } catch (e: Exception) {
                Log.e("LOAD_ERROR", "Error loadEconomyData", e)
            }
        }
    }



}