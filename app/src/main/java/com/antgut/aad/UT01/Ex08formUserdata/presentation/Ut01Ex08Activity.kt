package com.antgut.aad.UT01.Ex08formUserdata.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.antgut.aad.R
import com.antgut.aad.UT01.Ex08formUserdata.data.UserRepository
import com.antgut.aad.UT01.Ex08formUserdata.data.local.UsersLocalSource
import com.antgut.aad.UT01.Ex08formUserdata.data.remote.UsersRemoteSource
import com.antgut.aad.UT01.Ex08formUserdata.domain.Users

class Ut01Ex08Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex08)

        init()
    }

    fun init(){
        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        val usersRepository = UserRepository(
            UsersRemoteSource(),
            UsersLocalSource(sharedPref),

        )

        var users = usersRepository.getUsers()
        Log.d("@dev", "----------------------------------------------------------------------------")
        Log.d("@dev", "Lista")
        showUsers(users)
        Log.d("@dev", "----------------------------------------------------------------------------")
        Log.d("@dev", "user con id 5")
        val singleUser = usersRepository.findUserById(5)
        Log.d("@dev", singleUser.toString())
        Log.d("@dev", "----------------------------------------------------------------------------")
        Log.d("@dev", "borrar user id 2")
        usersRepository.removeUser(2)
        users = usersRepository.localSource.getUsers()
        Log.d("@dev", "mostrar lista")
        showUsers(users)
        Log.d("@dev", "----------------------------------------------------------------------------")

    }

    fun showUsers(lista: List<Users>?){
        lista?.forEach {
            Log.d("@dev", it.toString())
        }
    }
}