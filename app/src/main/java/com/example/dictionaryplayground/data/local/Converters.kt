package com.example.dictionaryplayground.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryplayground.data.util.JsonParser
import com.example.dictionaryplayground.domain.model.Meaning
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meaning: List<Meaning>): String {
        return jsonParser.toJson(
            obj = meaning,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }
}