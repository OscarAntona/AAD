package com.antgut.aad.UT01.Ex08formUserdata.data.remote

import com.antgut.aad.UT01.Ex08formUserdata.domain.Users
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {

    @GET("users")
    fun getUsers(): retrofit2.Call<List<Users>>

    @GET("users/{id}")
    fun getUser(@Path("id")id:Int): retrofit2.Call<Users>

}