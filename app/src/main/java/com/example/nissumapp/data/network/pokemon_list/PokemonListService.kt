package com.example.nissumapp.data.network.pokemon_list

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonListService @Inject constructor(private val pokemonListApi:PokemonListApiClient) {
    suspend fun getAllPokemon(): List<PokemonListResponse> {
        return withContext(Dispatchers.IO) {
            val pokemonList = mutableListOf<PokemonListResponse>()
            val response = pokemonListApi.getAllPokemon()
            if (response.isSuccessful){
                response.body()!!.pokemonList.forEach { pokemon ->
                    pokemonList.add(pokemon)
                }
            }
            pokemonList
        }
    }
}