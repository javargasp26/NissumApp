package com.example.nissumapp.di

import com.example.nissumapp.data.network.pokemon_detail.PokemonDetailApiClient
import com.example.nissumapp.data.network.pokemon_list.PokemonListApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            //.client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .build()
    }
    @Singleton
    @Provides
    fun providePokemonListApiClient(retrofit: Retrofit): PokemonListApiClient {
        return retrofit.create(PokemonListApiClient::class.java)
    }
    @Singleton
    @Provides
    fun providePokemonDetailApiClient(retrofit: Retrofit): PokemonDetailApiClient {
        return retrofit.create(PokemonDetailApiClient::class.java)
    }
}