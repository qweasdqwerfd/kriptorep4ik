package com.example.kriptorep4ik.logic

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CurrencyViewModel: ViewModel() {


    private val _mutableLiveData = MutableLiveData<List<ParserModel>>()
    val liveData: LiveData<List<ParserModel>> get() = _mutableLiveData

    fun loadData(scope: CoroutineScope) {
        scope.launch {
            try {
                val tempData = JsoupParser().getWeb()
                _mutableLiveData.postValue(tempData)

            } catch (e: Exception) {
                Log.e("CurrencyViewModel", "Error loading data: ${e.message}")
            }
        }
    }
}

//    private val _currencyRates = MutableLiveData<List<CurrencyRateModel>>()
//    val currencyRates: LiveData<List<CurrencyRateModel>> get() = _currencyRates
//
//    fun loadData(scope: CoroutineScope) {
//        scope.launch {
//            val parser = JsoupParser().getWeb()
//            _currencyRates.postValue(parser)
//
//            val additionalParser = AdditionalParser().getWeb()
//            Log.d("mylog", "addition data: " +"$additionalParser")
//        }
//    }