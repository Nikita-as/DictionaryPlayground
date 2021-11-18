package com.example.dictionaryplayground.domain.use_cases

import com.example.dictionaryplayground.core.Resource
import com.example.dictionaryplayground.domain.model.WordInfo
import com.example.dictionaryplayground.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfoUseCase(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word)
    }
}