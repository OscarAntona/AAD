package com.antgut.aad.UT01.ex02.data

import android.content.Context
import com.antgut.aad.R

import com.antgut.aad.UT01.ex02.domain.FirstOpened
const val KEY_IS_FIRST_OPENED="is_first_opened"

class Ut01Ex02SharedPreferenceLocalSource(private val context: Context) {

   private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_ut01Ex02),
       Context.MODE_PRIVATE)

    fun saveState(firstOpened: FirstOpened){
        val edit= sharedPref.edit()
        edit.putBoolean(KEY_IS_FIRST_OPENED,firstOpened.isFirstOpened)
        edit.apply()
    }
    fun getState(): FirstOpened {
        val edit= sharedPref.edit()
        return FirstOpened(sharedPref.getBoolean(KEY_IS_FIRST_OPENED,true))

        }
    }


