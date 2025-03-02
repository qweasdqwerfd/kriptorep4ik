package com.example.kriptorep4ik.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CurrencyViewModel: ViewModel() {
    private val _currencyRates = MutableLiveData<List<CurrencyRateModel>>()
    val currencyRates: LiveData<List<CurrencyRateModel>> get() = _currencyRates

    fun loadData(scope: CoroutineScope) {
        scope.launch {
            val parser = JsoupParser().getWeb()
            _currencyRates.postValue(parser)
        }
    }
}