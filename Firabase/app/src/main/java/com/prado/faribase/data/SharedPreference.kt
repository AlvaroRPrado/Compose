package com.prado.faribase.data

import android.content.Context
import android.content.SharedPreferences
import com.prado.faribase.base.Constants
import androidx.core.content.edit

class SharedPreference(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences(Constants.DATABASE.SHEREDPREFERENCE, Context.MODE_PRIVATE )

    fun save(key: String, value: String){
        preferences.edit { putString(key, value)?.apply()}
    }

    fun get(key: String): String {
        return preferences.getString(key, "") ?: ""
    }
   //1 edit
    fun saveID(key: String, value: Long){
        preferences.edit { putLong(key, value) }
    }
    //5 edit
    fun getByID(key: String): Long {
        return preferences.getLong(key, 0L)
    }
}