package com.example.aad22.ut01.ex03.data

import android.content.SharedPreferences
import android.util.Log
import com.example.aad22.ut01.ex03.domain.News
import com.google.gson.Gson

class NewsLocalSource (val sharedPref: SharedPreferences) {

    private val gson = Gson()

    fun setNews(news: News){
        val gson = Gson()
        val jsonNews = gson.toJson(news, News::class.java)

        val edit = sharedPref.edit()
        edit.putString(news.id.toString(), jsonNews)
        edit.apply()
    }

    fun findById(newsId: Int): News{
        val gson = Gson()
        val jsonNews = sharedPref.getString(newsId.toString(), "")
        return gson.fromJson<News>(jsonNews, News::class.java)
    }

    fun setNewsList(newList: MutableList<News>){
        for(n:News in newList){
            setNews(n)
        }
    }

    fun getNewsMap(): MutableList<News>{
        val newsList = mutableListOf<News>()
        sharedPref.all.forEach{ entry ->
            val news = gson.fromJson(entry.value as String, News::class.java)
            newsList.add(news)
        }
        return newsList
    }

    fun findAllKotlin():MutableList<News>{
        return sharedPref.all.map { entry ->
            gson.fromJson(entry.value as String, News::class.java)
        }.toMutableList()
    }


}