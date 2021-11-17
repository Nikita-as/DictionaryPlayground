package com.example.dictionaryplayground.domain.model

import com.example.dictionaryplayground.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>?,
    val partOfSpeech: String?
)
