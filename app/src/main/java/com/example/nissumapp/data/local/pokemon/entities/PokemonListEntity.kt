package com.example.nissumapp.data.local.pokemon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nissumapp.domain.pokemon_list.PokemonList

@Entity(tableName = "pokemon_list_table")
data class PokemonListEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int =0,
    @ColumnInfo(name = "pokemonId") val pokemonId:Int,
    @ColumnInfo(name = "pokemonName") val pokemonName: String,
    @ColumnInfo(name = "image") val image: String

)

fun PokemonList.toDatabase() = PokemonListEntity(
    pokemonId = pokemonId,
    pokemonName = pokemonName,
    image = image
)