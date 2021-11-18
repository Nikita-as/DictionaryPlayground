package com.example.dictionaryplayground.domain.model

data class WordInfo(
    val meanings: List<Meaning?>,
    val origin: String?,
    val phonetic: String?,
    val word: String?
)