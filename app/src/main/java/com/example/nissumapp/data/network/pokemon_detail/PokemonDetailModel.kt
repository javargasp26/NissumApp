package com.example.nissumapp.data.network.pokemon_detail

import com.google.gson.annotations.SerializedName


data class PokemonDetailModel(
    @SerializedName("name") val pokemonName: String,
    @SerializedName("id") val pokemonId: String,
    @SerializedName("types") val types: List<TypeResponse>,
    @SerializedName("abilities") val abilities: List<Ability>,
    @SerializedName("moves") val moves: List<Move>,
    @SerializedName("location_area_encounters") var location_url: String
)

data class TypeResponse(
    @SerializedName("type") val type: TypeDetail
)
data class TypeDetail(
    @SerializedName("name") val type_name: String
)

data class Move(
    @SerializedName("move") val move: MoveDetail
)
data class MoveDetail(
    @SerializedName("name") val move_name: String
)

data class Ability(
    @SerializedName("ability") val ability: AbilityDetail
)
data class AbilityDetail(
    @SerializedName("name") val ability_name: String
)