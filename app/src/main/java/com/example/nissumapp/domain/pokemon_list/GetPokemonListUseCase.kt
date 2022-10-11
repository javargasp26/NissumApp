package com.example.nissumapp.domain.pokemon_list

import com.example.nissumapp.data.local.pokemon.entities.toDatabase
import com.example.nissumapp.data.repository.PokemonListRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val repository: PokemonListRepository){

    suspend operator fun invoke(): List<PokemonList> {
        val pokemonList = repository.getAllPokemonFromDatabase()

        val pokemonToReturn: MutableList<PokemonList>

        if (pokemonList.isEmpty()){
            pokemonToReturn = repository.getAllPokemon().toMutableList()
            repository.clearPokemon()
            repository.insertPokemon(pokemonToReturn.map { it.toDatabase() })
        }else{
            pokemonToReturn = pokemonList.toMutableList()
        }

        return pokemonToReturn
    }

}