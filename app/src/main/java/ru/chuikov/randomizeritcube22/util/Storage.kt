package ru.chuikov.randomizeritcube22.util

import android.content.Context

import android.content.SharedPreferences
import com.google.gson.GsonBuilder


class Storage(private val context: Context) {
    val STORAGE_NAME = "StorageName"

    private val settings: SharedPreferences = context.getSharedPreferences(STORAGE_NAME,Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = settings.edit()

    fun addProperty(name: String, value: String) {
        editor.putString(name, value)
        editor.apply()
    }

    fun getProperty(name: String): String? {
        return settings.getString(name, null)
    }
}