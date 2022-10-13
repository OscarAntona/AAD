package com.antgut.aad.UT01.Ex08formUserdata.data.local

import android.content.SharedPreferences
import com.antgut.aad.UT01.Ex08formUserdata.domain.Users
import com.google.gson.Gson

class UsersLocalSource(val SharedPref: SharedPreferences) {
    private val gson = Gson()
    fun saveUser(user: Users){
        val jsonUsers = gson.toJson(user, Users::class.java)
        val edit = SharedPref.edit()
        edit.putString(user.id.toString(), jsonUsers)
        edit.apply()
    }
    fun saveUsers(users: List<Users>) {
        users?.forEach {
            saveUser(it)
        }
    }
    fun getUsers(): List<Users>{
        val userList = mutableListOf<Users>()
        SharedPref.all.forEach{entry ->
            val users = gson.fromJson(entry.value as String, Users::class.java)
            userList.add(users)
        }
        return userList
    }
    fun findUserById(userID: Int): Users {
        val jsonUsers = SharedPref.getString(userID.toString(),null)
        return gson.fromJson<Users>(jsonUsers, Users::class.java)
    }
    fun removeUser(userID: Int){
        SharedPref.edit().remove(userID.toString()).apply()
//
    }
}