package com.example.nissumapp.domain.pokemon_list

import com.example.nissumapp.data.local.pokemon.entities.PokemonListEntity
import com.example.nissumapp.data.network.pokemon_list.PokemonListResponse
import java.io.Serializable

data class PokemonList(
    val pokemonId: Int,
    val pokemonName: String,
    val image:String
): Serializable

fun PokemonListResponse.toDomain() = PokemonList(
    getId(url),
    name,
getImage(url))

fun getImage(url: String): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${url.substringAfter("pokemon/").substringBefore("/")}.png"
}

fun getId(url: String): Int {
    return url.substringAfter("pokemon/").substringBefore("/").toInt()
}

fun PokemonListEntity.toDomain() = PokemonList(pokemonId, pokemonName , image )

