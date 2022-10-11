package com.example.nissumapp.ui.main.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nissumapp.databinding.RowPokemonListItemBinding
import com.example.nissumapp.domain.pokemon_list.PokemonList

class ListAdapter (
    private val viewHolderListener: ListViewHolder.ViewHolderListener
) : RecyclerView.Adapter<ListViewHolder>() {

    private var pokemonList = mutableListOf<PokemonList>()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemBinding = RowPokemonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        this.context = parent.context
        return ListViewHolder(itemBinding, viewHolderListener)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(context, pokemonList[position])
    }

    fun setPokemonList(pokemonList: List<PokemonList>) {
        this.pokemonList.clear()
        this.pokemonList = pokemonList.toMutableList()
        notifyDataSetChanged()
    }

    fun isEmpty(): Boolean {
        return pokemonList.isEmpty()
    }

}