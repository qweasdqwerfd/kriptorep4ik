package com.example.kriptorep4ik.parse_data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kriptorep4ik.parse_data.commodities.Commodities
import com.example.kriptorep4ik.parse_data.commodities.MarketsModel
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel
import com.example.kriptorep4ik.parse_data.currency.ParserCurrency
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val _currencyState = MutableStateFlow<List<CurrencyModel>>(emptyList())
    val currencyState: StateFlow<List<CurrencyModel>> get() = _currencyState


    private val _parserData = MutableStateFlow<Map<String, List<MarketsModel>>>(emptyMap())
    val parserData: StateFlow<Map<String, List<MarketsModel>>> get() = _parserData

    init {
        loadCurrencyData()
        loadCommoditiesData()
    }

    private fun loadCurrencyData() {
        viewModelScope.launch {
            try {
                val tempData = ParserCurrency().getWeb()

                _currencyState.value = tempData

            } catch (e: Exception) {
                Log.e("ViewModel", "Error fetching data: ${e.message}")
            }
        }
    }

    private fun loadCommoditiesData() {
        viewModelScope.launch {
            try {
                val tempData = Commodities().getWeb()

                _parserData.value = tempData
            } catch (e: Exception) {
                Log.e("ViewModel", "Error fetching data: ${e.message}")
            }
        }
    }


}