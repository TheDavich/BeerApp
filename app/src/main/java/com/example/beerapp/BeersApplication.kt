package com.example.beerapp

import android.app.Application
import com.example.beerapp.data.AppContainer
import com.example.beerapp.data.DefaultAppContainer

class BeersApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}