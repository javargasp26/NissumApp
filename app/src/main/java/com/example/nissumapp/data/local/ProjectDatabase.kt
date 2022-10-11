package com.example.nissumapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nissumapp.data.local.pokemon.dao.PokemonListDao
import com.example.nissumapp.data.local.pokemon.entities.PokemonListEntity

@Database(entities = [PokemonListEntity::class], version = 1)
abstract class ProjectDatabase: RoomDatabase() {

    abstract fun getPokemonListDao(): PokemonListDao

}