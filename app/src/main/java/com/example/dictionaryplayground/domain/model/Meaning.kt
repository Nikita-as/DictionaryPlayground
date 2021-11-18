package com.example.dictionaryplayground.domain.model

data class Meaning(
    val definitions: List<Definition?>,
    val partOfSpeech: String?
)
