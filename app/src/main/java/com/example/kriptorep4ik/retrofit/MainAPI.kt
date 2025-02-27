package com.example.kriptorep4ik.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface MainAPI {
    @GET("?get=currency_list&key=YOUR-API-KEY")
    suspend fun getListAvailableCurrencies(
        @Query("key") apiKey: String
    )
}