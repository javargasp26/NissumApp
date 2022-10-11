package com.example.nissumapp.data.network.pokemon_list

import com.google.gson.annotations.SerializedName

data class PokemonListModel(
    @SerializedName("results") val pokemonList: List<PokemonListResponse>
)

data class PokemonListResponse(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String

)