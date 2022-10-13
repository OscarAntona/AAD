package com.example.aad22.ut01.ex05.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.antgut.aad.R

import com.example.aad22.ut01.ex05.data.UserRepository
import com.example.aad22.ut01.ex05.data.local.UsersLocalSource
import com.example.aad22.ut01.ex05.data.remote.UsersRemoteSource
import com.example.aad22.ut01.ex05.domain.User

class Ut01Ex05Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex05)

        init()
    }

    private fun init(){
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        //Obtain all users from data layer
        val userRepository = UserRepository(
            UsersLocalSource(sharedPref),
            UsersRemoteSource()
        )

        var users = userRepository.getUsers().toMutableList()
        mostrar(users)
        Log.d("@dev", "------------------------------------------------------------------------")
        userRepository.remove(3)
        users.clear()
        users = userRepository.getUsers().toMutableList()
        mostrar(users)
        Log.d("@dev", "------------------------------------------------------------------------")
        var user = userRepository.findById(1)
        Log.d("@dev", user.toString())
        // userRepository.localSource.removeAll()

    }

    fun mostrar(lista:List<User>){
        for(u:User in lista){
            Log.d("@dev", u.toString())
        }
    }
}