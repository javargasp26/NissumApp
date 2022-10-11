package com.example.nissumapp.ui.detail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.nissumapp.databinding.ActivityDetailBinding
import com.example.nissumapp.ui.detail.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val pokemonDetailViewModel: DetailViewModel by viewModels()

    var pokemonId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonId=intent.getIntExtra("pokemonId",0)

        if (pokemonId!=0){
            pokemonDetailViewModel.onCreate(pokemonId)
        }else{
            //show error
        }

        pokemonDetailViewModel.pokemonDetailModel.observe(this) { response ->

            bindImage(binding.imgPokemon, response.image)
            binding.tvName.text = response.pokemonName
            binding.tvAbility.text = response.abilities
            binding.tvLocation.text = response.locationUrl
            binding.tvType.text = response.type
            binding.tvMoves.text = response.moves

        }
        pokemonDetailViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
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
}