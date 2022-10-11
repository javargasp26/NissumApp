package com.example.nissumapp.domain.pokemon_detail

import com.example.nissumapp.data.local.pokemon.entities.toDatabase
import com.example.nissumapp.data.repository.PokemonDetailRepository
import com.example.nissumapp.data.repository.PokemonListRepository
import com.example.nissumapp.domain.pokemon_list.PokemonList
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val repository: PokemonDetailRepository){

    suspend operator fun invoke(pokemonId: Int): Pokemon {
        val pokemon = repository.getPokemonById(pokemonId)

        return pokemon
    }

}