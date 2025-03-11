package com.example.kriptorep4ik.parse_data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel
import com.example.kriptorep4ik.parse_data.currency.ParserCurrency
import com.example.kriptorep4ik.parse_data.resources.ParserResources
import com.example.kriptorep4ik.parse_data.resources.ResourcesModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {


    private val _currencyState = MutableStateFlow<List<CurrencyModel>>(emptyList())
    val currencyState: StateFlow<List<CurrencyModel>> get() = _currencyState

    private val _parserResourcesEnergy = MutableStateFlow<List<ResourcesModel>>(emptyList())
    val parserResourcesEnergy: StateFlow<List<ResourcesModel>> get() = _parserResourcesEnergy


    fun loadData() {
        viewModelScope.launch {
            try {
                val tempData = ParserCurrency().getWeb()
                _currencyState.value = tempData

            } catch (e: Exception) {
                Log.e("CurrencyViewModel", "Error loading data: ${e.message}")
            }
        }
    }


    fun fetchData() {
        viewModelScope.launch {
            try {
                val tempData = ParserResources().getWeb()
                _parserResourcesEnergy.value = tempData

            } catch (e: Exception) {
                Log.e("ResourcesEnergyViewModel", "Error loading data: ${e.message}")
            }
        }
    }
}

