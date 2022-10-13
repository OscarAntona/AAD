package com.example.aad22.ut01.ex06.data.local

import android.content.SharedPreferences
import com.example.aad22.ut01.ex06.domain.User
import com.google.gson.Gson

class UsersLocalSource (val sharedPref:SharedPreferences) {

    private val gson = Gson()

    fun saveUser(user: User){
        val jsonUser = gson.toJson(user, User::class.java)

        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
    }

    fun saveUsers(lista: List<User>){
        lista?.forEach {
            saveUser(it)
        }
    }

    fun getUsers():List<User>{
        val listUsers = mutableListOf<User>()
        sharedPref.all.forEach { entry ->
            var user = gson.fromJson<User>(entry.value as String, User::class.java)
            listUsers.add(user)
        }
        return listUsers
    }

    fun findUserById(userId:Int): User?{
        val jsonUser = sharedPref.getString(userId.toString(), null)
        return gson.fromJson(jsonUser, User::class.java)
    }

    fun removeUser(userId:Int){
        sharedPref.edit().remove(userId.toString()).apply()
    }

}