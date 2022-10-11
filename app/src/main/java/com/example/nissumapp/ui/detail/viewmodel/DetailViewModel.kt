package com.example.nissumapp.ui.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nissumapp.domain.pokemon_detail.GetPokemonDetailUseCase
import com.example.nissumapp.domain.pokemon_detail.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel

class DetailViewModel @Inject constructor(
private var getPokemonDetailUseCase : GetPokemonDetailUseCase
) : ViewModel() {

    val pokemonDetailModel = MutableLiveData<Pokemon>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(pokemonId: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val result = getPokemonDetailUseCase.invoke(pokemonId)

            if(result!=null){
                pokemonDetailModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}