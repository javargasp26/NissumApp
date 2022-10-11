package com.example.nissumapp.data.network.pokemon_detail

import com.example.nissumapp.data.network.pokemon_list.PokemonListApiClient
import com.example.nissumapp.data.network.pokemon_list.PokemonListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonDetailService @Inject constructor(private val pokemonDetailApiClient: PokemonDetailApiClient) {
    suspend fun getPokemonById(pokemonId:Int): PokemonDetailModel {
        return withContext(Dispatchers.IO) {

            val response = pokemonDetailApiClient.getPokemonById(pokemonId)

            if (response.isSuccessful){
                var location = pokemonDetailApiClient.getEncountersByPokemonById(pokemonId)
                var locationString=""
                if (location.isSuccessful){
                    if (location.body()!!.isEmpty()){
                        locationString = "no location found"
                    }else{
                        location.body()!!.forEach { location->
                            locationString += location.location_area.location_name.replace("-area", "") +", "
                        }
                    }
                }
                response.body()!!.location_url=locationString
                response.body()!!
            }else{
               PokemonDetailModel(
                   "",
                   "0",
                   mutableListOf(),
                   mutableListOf(),
                   mutableListOf(),
                   ""
               )
            }

        }
    }
}