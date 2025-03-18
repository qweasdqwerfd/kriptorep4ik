package com.example.kriptorep4ik.parse_data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kriptorep4ik.parse_data.commodities.AgriculturalParser
import com.example.kriptorep4ik.parse_data.commodities.ElectricityParser
import com.example.kriptorep4ik.parse_data.commodities.EnergyParser
import com.example.kriptorep4ik.parse_data.commodities.IndexParser
import com.example.kriptorep4ik.parse_data.commodities.IndustrialParser
import com.example.kriptorep4ik.parse_data.commodities.LiveStockParser
import com.example.kriptorep4ik.parse_data.commodities.MarketsModel
import com.example.kriptorep4ik.parse_data.commodities.MetalsParser
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
    val parserCommoditiesEnergy: StateFlow<List<MarketsModel>> get() = _parserCommoditiesEnergy

    private val _parserCommoditiesMetals = MutableStateFlow<List<MarketsModel>>(emptyList())
    val parserCommoditiesMetals: StateFlow<List<MarketsModel>> get() = _parserCommoditiesMetals

    private val _parserCommoditiesAgricultural = MutableStateFlow<List<MarketsModel>>(emptyList())
    val parserCommoditiesAgricultural: StateFlow<List<MarketsModel>> get() = _parserCommoditiesAgricultural

    private val _parserCommoditiesIndustrial = MutableStateFlow<List<MarketsModel>>(emptyList())
    val parserCommoditiesIndustrial: StateFlow<List<MarketsModel>> get() = _parserCommoditiesIndustrial

    private val _parserLiveStock = MutableStateFlow<List<MarketsModel>>(emptyList())
    val parserLiveStock: StateFlow<List<MarketsModel>> get() = _parserLiveStock

    private val _parserIndex = MutableStateFlow<List<MarketsModel>>(emptyList())
    val parserIndex: StateFlow<List<MarketsModel>> get() = _parserIndex

    private val _parserElectricity = MutableStateFlow<List<MarketsModel>>(emptyList())
    val parserElectricity: StateFlow<List<MarketsModel>> get() = _parserElectricity


    fun loadCurrencyData() {
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
    fun loadEnergyData() {
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

    fun loadMetalsData() {
        viewModelScope.launch {
            flow {
                while (true) {
                    try {
                        val tempData = MetalsParser().getWeb()
                        if (tempData.isNotEmpty()) {
                            emit(tempData)
                        }
                    } catch (e: Exception) {
                        Log.e("ViewModel", "Error fetching data: ${e.message}")
                    }
                    delay(1000)
                }
            }
                .debounce(1500)
                .distinctUntilChanged()
                .catch { e ->
                    Log.e(
                        "ViewModel",
                        "Data fetch failed: ${e.message}"
                    )
                } // Безопасная обработка ошибок
                .collect { tempData ->
                    if (tempData.isNotEmpty()) {
                        _parserCommoditiesMetals.value = tempData
                    }
                }
        }
    }

    fun loadAgriculturalData() {
        viewModelScope.launch {
            flow {
                while (true) {
                    try {
                        val tempData = AgriculturalParser().getWeb()
                        if (tempData.isNotEmpty()) {
                            emit(tempData)
                        }
                    } catch (e: Exception) {
                        Log.e("ViewModel", "Error fetching data: ${e.message}")
                    }
                    delay(1000)
                }
            }
                .debounce(1500)
                .distinctUntilChanged()
                .catch { e ->
                    Log.e(
                        "ViewModel",
                        "Data fetch failed: ${e.message}"
                    )
                } // Безопасная обработка ошибок
                .collect { tempData ->
                    if (tempData.isNotEmpty()) {
                        _parserCommoditiesAgricultural.value = tempData
                    }
                }
        }
    }

    fun loadIndustrialData() {
        viewModelScope.launch {
            flow {
                while (true) {
                    try {
                        val tempData = IndustrialParser().getWeb()
                        if (tempData.isNotEmpty()) {
                            emit(tempData)
                        }
                    } catch (e: Exception) {
                        Log.e("ViewModel", "Error fetching data: ${e.message}")
                    }
                    delay(1000)
                }
            }
                .debounce(1500)
                .distinctUntilChanged()
                .catch { e ->
                    Log.e(
                        "ViewModel",
                        "Data fetch failed: ${e.message}"
                    )
                } // Безопасная обработка ошибок
                .collect { tempData ->
                    if (tempData.isNotEmpty()) {
                        _parserCommoditiesIndustrial.value = tempData
                    }
                }
        }
    }

    fun loadLiveStockData() {
        viewModelScope.launch {
            flow {
                while (true) {
                    try {
                        val tempData = LiveStockParser().getWeb()
                        if (tempData.isNotEmpty()) {
                            emit(tempData)
                        }
                    } catch (e: Exception) {
                        Log.e("ViewModel", "Error fetching data: ${e.message}")
                    }
                    delay(1000)
                }
            }
                .debounce(1500)
                .distinctUntilChanged()
                .catch { e ->
                    Log.e(
                        "ViewModel",
                        "Data fetch failed: ${e.message}"
                    )
                } // Безопасная обработка ошибок
                .collect { tempData ->
                    if (tempData.isNotEmpty()) {
                        _parserLiveStock.value = tempData
                    }
                }
        }
    }

    fun loadIndexData() {
        viewModelScope.launch {
            flow {
                while (true) {
                    try {
                        val tempData = IndexParser().getWeb()
                        if (tempData.isNotEmpty()) {
                            emit(tempData)
                        }
                    } catch (e: Exception) {
                        Log.e("ViewModel", "Error fetching data: ${e.message}")
                    }
                    delay(1000)
                }
            }
                .debounce(1500)
                .distinctUntilChanged()
                .catch { e ->
                    Log.e(
                        "ViewModel",
                        "Data fetch failed: ${e.message}"
                    )
                } // Безопасная обработка ошибок
                .collect { tempData ->
                    if (tempData.isNotEmpty()) {
                        _parserIndex.value = tempData
                    }
                }
        }
    }

    fun loadElectricityData() {
        viewModelScope.launch {
            flow {
                while (true) {
                    try {
                        val tempData = ElectricityParser().getWeb()
                        if (tempData.isNotEmpty()) {
                            emit(tempData)
                        }
                    } catch (e: Exception) {
                        Log.e("ViewModel", "Error fetching data: ${e.message}")
                    }
                    delay(1000)
                }
            }
                .debounce(1500)
                .distinctUntilChanged()
                .catch { e ->
                    Log.e(
                        "ViewModel",
                        "Data fetch failed: ${e.message}"
                    )
                } // Безопасная обработка ошибок
                .collect { tempData ->
                    if (tempData.isNotEmpty()) {
                        _parserElectricity.value = tempData
                    }
                }
        }

    }


}
