package com.example.nissumapp.domain.pokemon_detail

import com.example.nissumapp.data.network.pokemon_detail.Ability
import com.example.nissumapp.data.network.pokemon_detail.Move
import com.example.nissumapp.data.network.pokemon_detail.PokemonDetailModel
import com.example.nissumapp.data.network.pokemon_detail.TypeResponse
import java.io.Serializable

data class Pokemon(
    val pokemonId: Int,
    val pokemonName: String,
    val image:String,
    val type:String,
    val moves: String,
    val abilities: String,
    val locationUrl: String,
    val location: String=""
): Serializable

fun PokemonDetailModel.toDomain() = Pokemon(
    pokemonId.toInt(),
    pokemonName,
    getImage(pokemonId),
    getTypes(types),
    getMoves(moves),
    getAbilities(abilities),
    location_url,
    location_url
)

fun getImage(id: String): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
}

fun getAbilities(abilities: List<Ability>): String {
    var abilitiesString = ""
    if (abilities.isEmpty()){
        abilitiesString = "no ability found"
    }else{
        abilities.forEach { ability->
            abilitiesString += ability.ability.ability_name+ ", "
        }
    }
    return abilitiesString
}

fun getMoves(moves: List<Move>): String {
    var movesString = ""
    if (moves.isEmpty()){
        movesString = "no move found"
    }else{
        moves.forEach { move->
            movesString += move.move.move_name + ", "
        }
    }
    return movesString
}

fun getTypes(types: List<TypeResponse>): String {
    var typesString = ""
    if (types.isEmpty()){
        typesString = "no types found"
    }else{
        types.forEach { type->
            typesString += type.type.type_name+ ", "
        }
    }
    return typesString
}
