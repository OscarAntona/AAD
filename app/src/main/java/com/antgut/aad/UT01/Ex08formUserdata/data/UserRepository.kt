package com.antgut.aad.UT01.Ex08formUserdata.data
import com.antgut.aad.UT01.Ex08formUserdata.data.local.UsersLocalSource
import com.antgut.aad.UT01.Ex08formUserdata.data.remote.UsersRemoteSource
import com.antgut.aad.UT01.Ex08formUserdata.domain.Users

class UserRepository(val remoteSource: UsersRemoteSource, val localSource: UsersLocalSource){

    fun getUsers(): List<Users> {
        return localSource.getUsers().isEmpty().run{
            val users = remoteSource.getUsers()
            localSource.saveUsers(users)
            users
        }
    }
    fun findUserById(userId:Int): Users? {
        return localSource.findUserById(userId)?.let {
            remoteSource.getUser(userId)
        }
    }

    fun removeUser(userId:Int){
        localSource.removeUser(userId)
    }

}


