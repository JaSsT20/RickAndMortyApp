package com.levid.rickandmortyapp.data.source.remote.dto
import com.levid.rickandmortyapp.domain.model.Character
data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDto.toCharacter(): Character{
    return Character(
        id = id,
        name = name,
        status = status,
        specie = species,
        origin = origin,
        gender = gender,
        location = location,
        image = image
    )
}