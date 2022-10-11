package com.example.nissumapp.data.network.pokemon_detail

import com.google.gson.annotations.SerializedName

data class PokemonEncountersModel(
    @SerializedName("location_area") val location_area: LocationEncounters
)

data class LocationEncounters(
    @SerializedName("name") val location_name: String
)