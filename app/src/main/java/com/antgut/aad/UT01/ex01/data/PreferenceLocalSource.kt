package com.antgut.aad.UT01.ex01.data

import android.app.Activity
import android.content.Context
import com.antgut.aad.UT01.ex01.domain.Customer

class PreferenceLocalSource (private val activity: Activity) {
    val sharedPref = activity.getPreferences(
        Context.MODE_PRIVATE
    )

    fun saveCustomer(customer: Customer) {
        val editor = sharedPref.edit()
        editor.putInt("id", customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active", customer.isActive)
        editor.apply()
    }

    fun getCustomer(): Customer {
        return Customer(
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no existe")!!,
            sharedPref.getString("surname", "no existe")!!,
            sharedPref.getBoolean("isActive", true)
        )
    }
}