package com.levid.rickandmortyapp.data.source.remote

import com.levid.rickandmortyapp.data.source.remote.dto.CharacterDto
import com.levid.rickandmortyapp.data.source.remote.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyAPI {
    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page : Int
    ): CharactersDto

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id : Int
    ): CharacterDto
}