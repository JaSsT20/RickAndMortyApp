package com.levid.rickandmortyapp.domain.repositories
import com.levid.rickandmortyapp.data.Result
import com.levid.rickandmortyapp.domain.model.Characters
import com.levid.rickandmortyapp.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(page: Int): Flow<Result<List<Characters>>>

    suspend fun getCharacter(id: Int) : Result<Character>
}