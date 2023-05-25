package com.example.beerapp.data

import com.example.beerapp.network.BeersApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val beersRepository: BeersRepository
}

class DefaultAppContainer: AppContainer {
    private val BASE_URL = "https://api.punkapi.com/v2/"

    private val json = Json {
        ignoreUnknownKeys = true // Add this line to ignore unknown keys
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val retrofitService: BeersApiService by lazy {
        retrofit.create(BeersApiService::class.java)
    }

    override val beersRepository: BeersRepository
        get() = DefaultBeersRepository(retrofitService)
}
