package com.example.nissumapp.data.repository

import com.example.nissumapp.data.local.pokemon.dao.PokemonListDao
import com.example.nissumapp.data.local.pokemon.entities.PokemonListEntity
import com.example.nissumapp.data.network.pokemon_detail.PokemonDetailService
import com.example.nissumapp.data.network.pokemon_list.PokemonListService
import com.example.nissumapp.domain.pokemon_detail.Pokemon
import com.example.nissumapp.domain.pokemon_detail.toDomain
import com.example.nissumapp.domain.pokemon_list.PokemonList
import com.example.nissumapp.domain.pokemon_list.toDomain
import javax.inject.Inject

class PokemonDetailRepository @Inject constructor(
    private val pokemonDetailApi : PokemonDetailService
){

    suspend fun getPokemonById(pokemonId:Int):Pokemon{
        val response = pokemonDetailApi.getPokemonById(pokemonId)
        return response.toDomain()
    }
}