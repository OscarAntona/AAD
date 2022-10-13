package com.example.aad22.ut01.ex06.data.remote


import com.example.aad22.ut01.ex06.domain.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val urlEndPoints = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoints:ApiEndPoint

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

    fun getUsers(): List<User> {
        val users = apiEndPoints.getUsers()
        val response = users.execute()
        return if(response.isSuccessful){
            response.body() ?: emptyList()
        }else{
            emptyList()
        }
    }

    fun getUser(id:Int): User?{
        val user = apiEndPoints.getUser(id)
        val response = user.execute()
        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }
}