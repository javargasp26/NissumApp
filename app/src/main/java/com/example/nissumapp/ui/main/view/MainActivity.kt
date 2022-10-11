package com.example.nissumapp.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nissumapp.databinding.ActivityMainBinding
import com.example.nissumapp.domain.pokemon_list.PokemonList
import com.example.nissumapp.ui.detail.view.DetailActivity
import com.example.nissumapp.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity(), ListViewHolder.ViewHolderListener {

    private val pokemonListViewModel: MainViewModel by viewModels()
    var pokemonList = mutableListOf<PokemonList>()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var bindingMainActivity: ActivityMainBinding
    private val pokemonAdapter = ListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)
        pokemonListViewModel.onCreate()

        pokemonListViewModel.pokemonListModel.observe(this) { response ->
            pokemonList = response.toMutableList()
            if (pokemonList.isNotEmpty()){
                setAdapter(pokemonList)
            }
        }
        pokemonListViewModel.isLoading.observe(this, Observer {
            bindingMainActivity.loading.isVisible = it
            bindingMainActivity.svPokemon.isVisible = !it
        })

        bindingMainActivity.svPokemon.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                val filtered = pokemonList.filter { item ->
                    item.pokemonName.contains(query.toString())
                }
                pokemonAdapter.setPokemonList(filtered)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                val filtered = pokemonList.filter { item ->
                    item.pokemonName.contains(newText.toString())
                }
                pokemonAdapter.setPokemonList(filtered)
                return true
            }
        })
    }

    private fun setAdapter(pokemonList: MutableList<PokemonList>) {
        linearLayoutManager = LinearLayoutManager(this)
        bindingMainActivity.rcvPokemon.layoutManager = linearLayoutManager

        bindingMainActivity.rcvPokemon.adapter = pokemonAdapter
        pokemonAdapter.setPokemonList(pokemonList)
        bindingMainActivity.rcvPokemon.visibility = View.VISIBLE
    }

    override fun onClick(id: Int) {

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("pokemonId", id)
        startActivity(intent)
    }
}