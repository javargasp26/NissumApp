package com.example.nissumapp.data.network.pokemon_detail

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonDetailApiClient {
    @GET("pokemon/{pokemon_id}")
    suspend fun getPokemonById(@Path("pokemon_id")pokemonId: Int): Response<PokemonDetailModel>

    @GET("pokemon/{pokemon_id}/encounters")
    suspend fun getEncountersByPokemonById(@Path("pokemon_id")pokemonId: Int): Response<List<PokemonEncountersModel>>
}