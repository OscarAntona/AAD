package com.antgut.aad.UT01

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.antgut.aad.R
import com.antgut.aad.UT01.ex01.data.PreferenceLocalSource
import com.antgut.aad.UT01.ex01.data.SharedPreferenceLocalSource
import com.antgut.aad.UT01.ex01.domain.Customer


class Ut01Ex01Activity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_ut01ex01)

            initSharedPreferences()
            initPreferences()

        }

        private fun initSharedPreferences(){
            val spCustomer = SharedPreferenceLocalSource(this)
            spCustomer.saveCustomer(Customer(1, "Customer1", "Surname", true))
            spCustomer.getCustomer()
            val newCustomer = spCustomer.getCustomer()
            Log.d( "@dev", "Customer: $newCustomer")
        }

    private fun initPreferences(){
        val spCustomer = PreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1, "Customer1", "Surname", true))
        spCustomer.getCustomer()
        val newCustomer = spCustomer.getCustomer()
        Log.d( "@dev", "Customer: $newCustomer")
    }
}