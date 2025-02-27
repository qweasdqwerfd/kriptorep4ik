package com.example.kriptorep4ik.logic;

import androidx.lifecycle.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//public class CurrencyViewModel extends ViewModel {
//    private final MutableLiveData<List<CurrencyRate>> currencyRates = new MutableLiveData<>();
//    private final ExecutorService executor = Executors.newSingleThreadExecutor();
//    private final JsoupParser parser = new JsoupParser();
//
//    public LiveData<List<CurrencyRate>> getCurrencyRates() {
//        return currencyRates;
//    }
//
//    public void loadRates() {
//        executor.execute(() -> {
//            List<CurrencyRate> rates = parser.getCurrencyRates();
//            currencyRates.postValue(rates); // Обновляем UI-поток
//        });
//    }
//}
