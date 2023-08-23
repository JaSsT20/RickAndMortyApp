package com.levid.rickandmortyapp.di

import com.levid.rickandmortyapp.data.source.remote.RickAndMortyAPI
import com.levid.rickandmortyapp.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)

object RemoteModule {
    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyAPI::class.java)
    }
}