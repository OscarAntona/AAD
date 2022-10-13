package com.antgut.aad.UT01.Ex08formUserdata.data.remote

import com.antgut.aad.UT01.Ex08formUserdata.domain.Users
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient  {
    private val urlEndPoints = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoints: ApiEndPoint


    init{
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoints)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoints():ApiEndPoint{
        return buildClient().create(ApiEndPoint::class.java)
    }

    fun getUsers(): List<Users> {
        val users = apiEndPoints.getUsers()
        val response = users.execute()
        return if(response.isSuccessful){
            response.body() ?: emptyList()
        }else{
            emptyList()
        }
    }

    fun getUser(id:Int): Users?{
        val user = apiEndPoints.getUser(id)
        val response = user.execute()
        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }
}
