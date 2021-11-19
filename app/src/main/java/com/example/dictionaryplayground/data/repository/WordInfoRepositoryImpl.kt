package com.example.dictionaryplayground.data.repository

import com.example.dictionaryplayground.core.Resource
import com.example.dictionaryplayground.data.local.WordInfoDao
import com.example.dictionaryplayground.data.remote.DictionaryApi
import com.example.dictionaryplayground.domain.model.WordInfo
import com.example.dictionaryplayground.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfo = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfo))

        try {
            val remoteWordInfo = api.getWordInfo(word)
            if (remoteWordInfo.isNotEmpty()) {
                remoteWordInfo.map { it.word }.let { dao.deleteWordInfo(it as List<String>) }
                dao.insertWordInfo(remoteWordInfo.map { it.toWordInfoEntity() })
            }
        }
        catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Мы не нашли ничего подходящего",
                    data = wordInfo
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Не удалось получить данные, проверьте интернет соединение",
                    data = wordInfo
                )
            )
        }

        val newWordInfo = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))
    }
}