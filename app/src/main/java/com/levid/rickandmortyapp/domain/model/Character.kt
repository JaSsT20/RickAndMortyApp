package com.levid.rickandmortyapp.domain.model

import com.levid.rickandmortyapp.data.source.remote.dto.Location
import com.levid.rickandmortyapp.data.source.remote.dto.Origin

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val specie: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String
)
