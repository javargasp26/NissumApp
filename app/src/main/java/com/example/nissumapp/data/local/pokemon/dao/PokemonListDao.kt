package com.example.nissumapp.data.local.pokemon.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nissumapp.data.local.pokemon.entities.PokemonListEntity


@Dao
interface PokemonListDao {

    @Query("SELECT * FROM pokemon_list_table ORDER BY pokemonId ASC")
    suspend fun getAllPokemon(): List<PokemonListEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemon(pokemonList: List<PokemonListEntity>)

    @Query("DELETE FROM pokemon_list_table")
    suspend fun clearPokemon()
}