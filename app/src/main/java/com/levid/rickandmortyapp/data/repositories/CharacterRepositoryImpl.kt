package com.levid.rickandmortyapp.data.repositories

import com.levid.rickandmortyapp.data.Result
import com.levid.rickandmortyapp.data.source.remote.RickAndMortyAPI
import com.levid.rickandmortyapp.data.source.remote.dto.toCharacter
import com.levid.rickandmortyapp.data.source.remote.dto.toListCharacters
import com.levid.rickandmortyapp.domain.model.Character
import com.levid.rickandmortyapp.domain.model.Characters
import com.levid.rickandmortyapp.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyAPI
): CharacterRepository{

    override fun getCharacters(page: Int): Flow<Result<List<Characters>>> = flow{
        emit(Result.Loading())
        try {
            val response = api.getCharacters(page).toListCharacters()
            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(Result.Error(
                message = "Oops, something went wrong",
                data = null
            ))
        } catch (e: IOException) {
            emit(Result.Error(
                message = "Couldn't reach server, check your internet connection",
                data = null
            ))
        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        val response = try {
            api.getCharacter(id)
        } catch (e: Exception) {
            return Result.Error("An unknown error occurred")
        }
        return Result.Success(response.toCharacter())
    }
}