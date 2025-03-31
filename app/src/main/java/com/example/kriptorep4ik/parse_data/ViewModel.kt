package com.example.kriptorep4ik.parse_data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel
import com.example.kriptorep4ik.parse_data.currency.ParserCurrency
import com.example.kriptorep4ik.parse_data.markets.getAllMarkets
import com.example.kriptorep4ik.parse_data.models.MarketModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {


    private val _currencyState = MutableStateFlow<List<CurrencyModel>>(emptyList())
    val currencyState: StateFlow<List<CurrencyModel>> get() = _currencyState




    private val _getAllMarketsState = MutableStateFlow<Map<String, Map<String, List<MarketModel>>>>(emptyMap())
    val getAllMarketsState: StateFlow<Map<String, Map<String, List<MarketModel>>>> get() = _getAllMarketsState

    init {
        loadCurrencyData()
        loadGetAllMarkets()
    }



    private fun loadCurrencyData() {
        viewModelScope.launch {
            try {
                val tempData = ParserCurrency().getWeb()

                _currencyState.value = tempData

            } catch (e: Exception) {
                Log.e("ViewModel", "Error load currency data: ${e.message}")
            }
        }
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
}