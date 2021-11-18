package com.example.dictionaryplayground.presentation

import com.example.dictionaryplayground.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
