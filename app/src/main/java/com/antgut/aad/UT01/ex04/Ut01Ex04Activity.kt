package com.example.aad22.ut01.ex04

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aad22.ut01.ex04.data.SecureSharedPreference
import com.example.aad22.ut01.ex04.domain.Customer

class Ut01Ex04Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        val secureSharedPreference = SecureSharedPreference(
            this
        )

        val cust = Customer(1, "Alberto")
        secureSharedPreference.saveCustomer(cust)
    }


}