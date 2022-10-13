package com.example.aad22.ut01.ex07.data

import android.content.SharedPreferences
import com.example.aad22.ut01.ex07.domain.Counter
import com.google.gson.Gson

class LocalDataSource (val sharedPref:SharedPreferences){

    private val gson = Gson()

    fun saveCounter(counter:Counter){
        val jsonCounter = gson.toJson(counter, Counter::class.java)

        val edit = sharedPref.edit()
        edit.putString(counter.id.toString(), jsonCounter)
        edit.apply()
    }

    fun getCounter(counterId:Int):Counter?{
        val jsonCounter = sharedPref.getString(counterId.toString(), null)
        return gson.fromJson(jsonCounter, Counter::class.java)
    }

}