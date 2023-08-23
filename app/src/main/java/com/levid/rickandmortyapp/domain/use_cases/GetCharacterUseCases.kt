package com.levid.rickandmortyapp.domain.use_cases

import com.levid.rickandmortyapp.data.Result
import com.levid.rickandmortyapp.domain.model.Character
import com.levid.rickandmortyapp.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int): Result<Character> {
        return repository.getCharacter(id)
    }
}