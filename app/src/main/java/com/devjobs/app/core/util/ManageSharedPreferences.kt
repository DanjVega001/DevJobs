package com.devjobs.app.core.util

import android.content.Context
import com.devjobs.app.R

object ManageSharedPreferences {

    fun savePreferences(key:String, value:String, context:Context){
        val prefs = context.getSharedPreferences(context.getString(R.string.preferences_key), Context.MODE_PRIVATE)
        prefs.edit().putString(key, value).apply()
    }

    fun getPreferences(key: String, context: Context):String {
        val prefs = context.getSharedPreferences(context.getString(R.string.preferences_key), Context.MODE_PRIVATE)
        return prefs.getString(key, "") ?: ""
    }


}