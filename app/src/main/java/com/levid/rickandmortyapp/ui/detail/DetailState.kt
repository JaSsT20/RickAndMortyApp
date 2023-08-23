package com.levid.rickandmortyapp.ui.detail

import com.levid.rickandmortyapp.domain.model.Character

data class DetailState(
    val character: Character? = null,
    val isLoading: Boolean = false
)