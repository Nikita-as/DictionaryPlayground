package com.example.dictionaryplayground.domain.repository

import com.example.dictionaryplayground.core.Resource
import com.example.dictionaryplayground.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}