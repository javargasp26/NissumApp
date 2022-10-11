package com.example.nissumapp.ui.main.view

import android.content.Context
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nissumapp.databinding.RowPokemonListItemBinding
import com.example.nissumapp.domain.pokemon_list.PokemonList

class ListViewHolder(private val itemBinding: RowPokemonListItemBinding, viewHolderListener: ViewHolderListener) :
    RecyclerView.ViewHolder(itemBinding.root) {

    val holder: ViewHolderListener = viewHolderListener

    fun bind(context: Context, pokemon: PokemonList) {
        itemBinding.tvTitle.text = pokemon.pokemonName

        itemBinding.lytContentCard.setOnClickListener {
            holder.onClick(pokemon.pokemonId)
        }

        bindImage(itemBinding.imgPokemon, pokemon.image)
    }

    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri =
                imgUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .into(imgView)
        }
    }

    interface ViewHolderListener {
        fun onClick(
            id: Int
        )
    }
}