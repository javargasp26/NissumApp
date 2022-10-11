package com.example.nissumapp.data.repository

import com.example.nissumapp.data.local.pokemon.dao.PokemonListDao
import com.example.nissumapp.data.local.pokemon.entities.PokemonListEntity
import com.example.nissumapp.data.network.pokemon_list.PokemonListService
import com.example.nissumapp.domain.pokemon_list.PokemonList
import com.example.nissumapp.domain.pokemon_list.toDomain
import javax.inject.Inject

class PokemonListRepository @Inject constructor(
    private val pokemonApi : PokemonListService,
    private val pokemonListDao: PokemonListDao){

    suspend fun getAllPokemon():List<PokemonList>{
        val response = pokemonApi.getAllPokemon()
        return response.map { it.toDomain() }
    }

    suspend fun getAllPokemonFromDatabase():List<PokemonList>{
        val response = pokemonListDao.getAllPokemon()
        return response.map { it.toDomain() }
    }

    suspend fun insertPokemon(pokemons: List<PokemonListEntity>) {
        pokemonListDao.insertAllPokemon(pokemons)
    }

    suspend fun clearPokemon() {
        pokemonListDao.clearPokemon()
    }
}