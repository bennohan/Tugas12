package com.example.tugas12

import android.content.Context
import android.content.SharedPreferences

class Database(context: Context) {

    private var pref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveName(value: String?) {
        val editor = pref.edit()
        editor?.putString(KEY_NAME, value)
        editor?.apply()
    }

    fun getName(): String?{
        return pref.getString(KEY_NAME,"_")
    }

    companion object{
        const val PREF_NAME = "Dataku"
        const val KEY_NAME ="name"
    }
    }
