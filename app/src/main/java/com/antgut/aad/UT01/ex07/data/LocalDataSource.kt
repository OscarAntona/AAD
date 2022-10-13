package com.example.aad22.ut01.ex07.data

import android.content.SharedPreferences
import com.example.aad22.ut01.ex07.domain.Contador
import com.google.gson.Gson

class LocalDataSource (val sharedPref:SharedPreferences){

    private val gson = Gson()

    fun saveCounter(contador:Contador){
        val jsonContador = gson.toJson(contador, Contador::class.java)

        val edit = sharedPref.edit()
        edit.putString(contador.id.toString(), jsonContador)
        edit.apply()
    }

    fun getCounter(counterId:Int):Contador?{
        val jsonCounter = sharedPref.getString(counterId.toString(), null)
        return gson.fromJson(jsonCounter, Contador::class.java)
    }

}