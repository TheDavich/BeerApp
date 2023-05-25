package com.example.beerapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Beers (
    val id: Int,
    val name: String,
    val tagline: String,
    @SerialName("first_brewed") val firstBrewed:String,
    val description: String,
    @SerialName("image_url") val imageUrl: String,

)