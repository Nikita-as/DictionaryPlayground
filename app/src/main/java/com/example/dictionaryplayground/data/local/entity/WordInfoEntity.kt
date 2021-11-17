package com.example.dictionaryplayground.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryplayground.domain.model.Meaning
import com.example.dictionaryplayground.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    @PrimaryKey val id: Int? = null,
    val meanings: List<Meaning>?,
    val origin: String?,
    val phonetic: String?,
    val word: String?
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            word = word,
            origin = origin,
            phonetic = phonetic
        )
    }
}