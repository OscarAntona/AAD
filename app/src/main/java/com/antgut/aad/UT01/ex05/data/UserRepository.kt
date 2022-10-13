package com.example.aad22.ut01.ex05.data

import com.example.aad22.ut01.ex05.data.local.UsersLocalSource
import com.example.aad22.ut01.ex05.data.remote.UsersRemoteSource
import com.example.aad22.ut01.ex05.domain.User

class UserRepository(

    val localSource:UsersLocalSource,
    val remoteSource:UsersRemoteSource

) {

    //First from local and after that, from remote

    fun getUsers(): List<User>{
        return localSource.getUsers().isEmpty().run {
            val users = remoteSource.getUsers()
            localSource.saveUsers(users)
            users
        }
    }

    fun findById(userId:Int): User?{
        var user = localSource.findById(userId)
        return user
    }

    fun remove(userId: Int){
        localSource.remove(userId)
    }

}