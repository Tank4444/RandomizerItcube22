package ru.chuikov.randomizeritcube22.util

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import ru.chuikov.randomizeritcube22.dao.Audience


class AudienceStorage(context: Context) {
    private val AUDIENCE_NAME = "AUDIENCE"
    private var listType = object : TypeToken<ArrayList<Audience>>() {}.type

    private val storage = Storage(context)
    private val gson = GsonBuilder().create()

    fun setAudience(list: List<Audience>){
        storage.addProperty(AUDIENCE_NAME,gson.toJson(list))
    }
    fun getAudience():List<Audience>?{
        val json = storage.getProperty(AUDIENCE_NAME) ?: return null
        return gson.fromJson(json, listType)
    }
}