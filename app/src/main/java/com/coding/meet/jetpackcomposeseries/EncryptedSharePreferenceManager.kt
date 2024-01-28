package com.coding.meet.jetpackcomposeseries

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

/**
 * @author Coding Meet
 * Created 26-01-2024 at 02:55 pm
 */

class EncryptedSharePreferenceManager(
    context: Context
) {
    private val mainKeyAlias =  MasterKeys.getOrCreate(
        MasterKeys.AES256_GCM_SPEC
    )
    private val preferences = EncryptedSharedPreferences.create(
        "preferences",
        mainKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
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