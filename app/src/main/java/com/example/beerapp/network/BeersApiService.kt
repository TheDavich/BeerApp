package com.example.beerapp.network

import com.example.beerapp.model.Beers
import retrofit2.http.GET

interface BeersApiService {
    @GET("beers")
    suspend fun getBeers(): List<Beers>
}