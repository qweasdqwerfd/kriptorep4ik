package com.example.kriptorep4ik.parse_data

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

