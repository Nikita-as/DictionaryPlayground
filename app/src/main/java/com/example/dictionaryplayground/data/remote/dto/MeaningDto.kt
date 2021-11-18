package com.example.dictionaryplayground.data.remote.dto

import com.example.dictionaryplayground.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto?>,
    val partOfSpeech: String?
) {
    fun toMeaning(): Meaning {
        return Meaning(
            definitions = definitions.map { it?.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}