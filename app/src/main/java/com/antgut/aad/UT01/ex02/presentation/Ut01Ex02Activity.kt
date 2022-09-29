package com.antgut.aad.UT01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.antgut.aad.R
import com.antgut.aad.UT01.ex02.data.Ut01Ex02SharedPreferenceLocalSource
import com.antgut.aad.UT01.ex02.domain.FirstOpened

class Ut01Ex02Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex02)
        initSharedPreferences()
    }
    private fun initSharedPreferences(){
        val SharedPref = Ut01Ex02SharedPreferenceLocalSource(this)
        firstOpenedInfo(SharedPref.getState())
        SharedPref.saveState(FirstOpened(false))
    }
    private fun firstOpenedInfo(firstOpened: FirstOpened){
        if (firstOpened.isFirstOpened){
            Log.d("@dev", "Es la primera apertura de la aplicacion:${firstOpened.isFirstOpened}")
        } else {
            Log.d("@dev", "No es la primera vez que se abre la aplicacion:${firstOpened.isFirstOpened}")

        }
    }

}