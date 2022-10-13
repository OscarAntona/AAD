package com.example.aad22.ut01.ex05.data.remote

import com.example.aad22.ut01.ex05.domain.User

class UsersRemoteSource {

    fun getUsers():List<User>{
        return mutableListOf(
            User(1, "User1", "Username1"),
            User(2, "User2", "Username2"),
            User(3, "User3", "Username3"),
            User(4, "User4", "Username4"),
            User(5, "User5", "Username5"),
            User(6, "User6", "Username6"),
            User(7, "User7", "Username7")
        )
    }

    fun findById(userId:Int):User{
        return User(userId, "User$userId", "Username$userId")
    }
}