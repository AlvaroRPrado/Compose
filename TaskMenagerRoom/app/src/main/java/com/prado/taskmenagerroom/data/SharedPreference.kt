package com.prado.taskmenagerroom.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("localdata", Context.MODE_PRIVATE )

    fun save(key: String, value: String){
        preferences.edit()?.putString(key, value)?.apply()
    }
    fun delete(key: String){
        preferences.edit()?.remove(key)?.apply()
    }
    fun get(key: String): String {
        return preferences.getString(key, "") ?: ""
    }
}