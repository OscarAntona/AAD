package com.antgut.aad.UT01.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.antgut.aad.R
import com.antgut.aad.UT01.domain.Customer


class SharedPreferenceLocalSource (val context: Context) {

    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_ut01Ex01), Context.MODE_PRIVATE
    )

    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()
        editor.putInt("id", customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active", customer.isActive)
        editor.apply() //de forma asincrona -- cuando nos de igual cuando termine
        //!editor.commit() //de forma sincrona
        //con kotlin
       /* editor.apply{
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("is_active", customer.isActive)
            apply()
        }*/
    }
    fun getCustomer(): Customer{
        return Customer (
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no existe")!!,
            sharedPref.getString("surname", "no existe")!!,
            sharedPref.getBoolean("isActive", true)
        )
    }
}