package com.coding.meet.jetpackcomposeseries

import android.content.Context

/**
 * @author Coding Meet
 * Created 26-01-2024 at 02:55 pm
 */

class SharePreferenceManager(
    context: Context
) {
    private val preferences = context.getSharedPreferences(
        context.packageName,
        Context.MODE_PRIVATE
    )
    private val editor = preferences.edit()

    private val keyName = "name"
    private val keyAge = "age"

    var name
        get() = preferences.getString(keyName,"").toString()
        set(value) {
            editor.putString(keyName,value)
            editor.commit()
        }

    var age
        get() = preferences.getInt(keyAge,0)
        set(value) {
            editor.putInt(keyAge,value)
            editor.commit()
        }

    fun clear(){
        editor.clear()
        editor.commit()
    }
}