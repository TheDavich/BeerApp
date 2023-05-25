package com.example.beerapp.data

import com.example.beerapp.model.Beers
import com.example.beerapp.network.BeersApiService

interface BeersRepository {
    suspend fun getBeers(): List<Beers>
}

class DefaultBeersRepository(
    private val beersApiService: BeersApiService
) : BeersRepository {
    override suspend fun getBeers(): List<Beers> = beersApiService.getBeers()
}