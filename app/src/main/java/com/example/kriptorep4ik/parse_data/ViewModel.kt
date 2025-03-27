package com.example.kriptorep4ik.parse_data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel
import com.example.kriptorep4ik.parse_data.currency.ParserCurrency
import com.example.kriptorep4ik.parse_data.markets.Commodities
import com.example.kriptorep4ik.parse_data.markets.getAllMarkets
import com.example.kriptorep4ik.parse_data.models.AllMarketsModel
import com.example.kriptorep4ik.parse_data.models.CommoditiesModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {


    private val _currencyState = MutableStateFlow<List<CurrencyModel>>(emptyList())
    val currencyState: StateFlow<List<CurrencyModel>> get() = _currencyState


    private val _commoditiesState = MutableStateFlow<Map<String, List<CommoditiesModel>>>(emptyMap())
    val commoditiesState: StateFlow<Map<String, List<CommoditiesModel>>> get() = _commoditiesState

    private val _getAllMarketsState = MutableStateFlow<Map<String, Map<String, List<AllMarketsModel>>>>(emptyMap())
    val getAllMarketsState: StateFlow<Map<String, Map<String, List<AllMarketsModel>>>> get() = _getAllMarketsState

    init {
        loadCurrencyData()
        loadCommoditiesData()
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

    private fun loadCommoditiesData() {
        viewModelScope.launch {
            try {
                val tempData = Commodities().getWeb()

                _commoditiesState.value = tempData
            } catch (e: Exception) {
                Log.e("ViewModel", "Error load commodities data: ${e.message}")
            }
        }
    }


    private fun loadGetAllMarkets() {
        viewModelScope.launch {
            try {
                val tempData = getAllMarkets()
                _getAllMarketsState.value = tempData

            } catch (e: Exception) {
                Log.e("ViewModel", "Error load getAllMarkets data: ${e.message}")
            }
        }

    }
}