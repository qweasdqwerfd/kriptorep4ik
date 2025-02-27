package com.example.kriptorep4ik.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://currate.ru/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: MainAPI by lazy {
        retrofit.create(MainAPI::class.java)
    }
}