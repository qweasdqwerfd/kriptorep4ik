package com.example.kriptorep4ik.parse_data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kriptorep4ik.parse_data.commodities.EnergyParser
import com.example.kriptorep4ik.parse_data.commodities.MarketsModel
import com.example.kriptorep4ik.parse_data.currency.CurrencyModel
import com.example.kriptorep4ik.parse_data.currency.ParserCurrency
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val _currencyState = MutableStateFlow<List<CurrencyModel>>(emptyList())
    val currencyState: StateFlow<List<CurrencyModel>> get() = _currencyState

    private val _parserCommoditiesEnergy = MutableStateFlow<List<MarketsModel>>(emptyList())
    val parserResourcesEnergy: StateFlow<List<MarketsModel>> get() = _parserCommoditiesEnergy

    private val refreshInterval = 2000L // Интервал между запросами данных

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

    @OptIn(FlowPreview::class)
    fun fetchData() {
        viewModelScope.launch {
            flow {
                while (true) {
                    try {
                        val tempData = EnergyParser().getWeb()
                        if (tempData.isNotEmpty()) {
                            emit(tempData)
                        }
                    } catch (e: Exception) {
                        Log.e("ViewModel", "Error fetching data: ${e.message}")
                    }
                    delay(1000) // Интервал запросов 1 секунда
                }
            }
                .debounce(1500) // Увеличил debounce до 1.5 секунды, чтобы исключить чрезмерное обновление UI
                .distinctUntilChanged() // Исключает дублирующиеся значения
                .catch { e ->
                    Log.e(
                        "ViewModel",
                        "Data fetch failed: ${e.message}"
                    )
                } // Безопасная обработка ошибок
                .collect { tempData ->
                    if (tempData.isNotEmpty()) {
                        _parserCommoditiesEnergy.value = tempData
                    }
                }
        }
    }

}
