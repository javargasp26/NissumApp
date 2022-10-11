package com.example.nissumapp.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nissumapp.domain.pokemon_list.GetPokemonListUseCase
import com.example.nissumapp.domain.pokemon_list.PokemonList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
     private var getPokemonListUseCase : GetPokemonListUseCase
) : ViewModel() {

    val pokemonListModel = MutableLiveData<List<PokemonList>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val result = getPokemonListUseCase()

            if(result.isNotEmpty()){
                pokemonListModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}