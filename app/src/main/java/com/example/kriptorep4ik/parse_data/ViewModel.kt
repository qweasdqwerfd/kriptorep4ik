package com.example.kriptorep4ik.parse_data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kriptorep4ik.parse_data.markets.getAllMarkets
import com.example.kriptorep4ik.parse_data.models.MarketModel
import com.example.kriptorep4ik.parse_data.news.NewsParser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val _getAllMarketsState = MutableStateFlow<Map<String, Map<String, List<MarketModel>>>>(emptyMap())
    val getAllMarketsState: StateFlow<Map<String, Map<String, List<MarketModel>>>> get() = _getAllMarketsState


    init {
        loadGetAllMarkets()
        loadTest()
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

    fun loadTest() {
        viewModelScope.launch {
            try {
                NewsParser().getWeb()

            } catch (e: Exception) {
                Log.e("ViewModel", "Error load Test data: ${e.message}")
            }
        }
    }
}