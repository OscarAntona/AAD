package com.example.aad22.ut01.ex06.data

import com.example.aad22.ut01.ex06.data.local.UsersLocalSource
import com.example.aad22.ut01.ex06.data.remote.RetrofitClient
import com.example.aad22.ut01.ex06.domain.User

class UserRepository (val remoteSource:RetrofitClient, val localSource: UsersLocalSource){

    fun getUsers(): List<User> {
        return localSource.getUsers().isEmpty().run{
            val users = remoteSource.getUsers()
            localSource.saveUsers(users)
            users
        }
    }

    fun findUserById(userId:Int): User? {
        return localSource.findUserById(userId)?.let {
            remoteSource.getUser(userId)
        }
    }

    fun removeUser(userId:Int){
        localSource.removeUser(userId)
    }

}