package com.levid.rickandmortyapp.domain.use_cases

import com.levid.rickandmortyapp.data.Result
import com.levid.rickandmortyapp.domain.model.Characters
import com.levid.rickandmortyapp.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(page: Int): Flow<Result<List<Characters>>> {
        return repository.getCharacters(page)
    }
}