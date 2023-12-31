package com.asterekhin.secretchat2.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ChatFactory {
    private const val BASE_URL = "http://89.22.229.252:8080/"

    private val client = OkHttpClient().newBuilder()
        .followRedirects(true)
        .addInterceptor(ChatInterceptor())
        .build()

    val service: ChatApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChatApi::class.java)
    }
}