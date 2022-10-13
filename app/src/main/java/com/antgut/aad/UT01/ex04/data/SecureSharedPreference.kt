package com.example.aad22.ut01.ex04.data

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.aad22.ut01.ex04.domain.Customer
import com.google.gson.Gson

class SecureSharedPreference (val applicationContext: Context){

    val gson = Gson()
    val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)


    val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        "SHARED_PREFS_FILE",
        mainKeyAlias,
        applicationContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveCustomer(c:Customer){
        val edit = sharedPreferences.edit()
        edit.putInt("id", c.id)
        edit.putString("name", c.name)
        edit.apply()
    }



}