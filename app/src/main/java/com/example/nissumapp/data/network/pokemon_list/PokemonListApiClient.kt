package com.example.nissumapp.data.network.pokemon_list

import retrofit2.Response
import retrofit2.http.GET

interface PokemonListApiClient {
    @GET("pokemon?limit=150&offset=0")
    suspend fun getAllPokemon(): Response<PokemonListModel>
}