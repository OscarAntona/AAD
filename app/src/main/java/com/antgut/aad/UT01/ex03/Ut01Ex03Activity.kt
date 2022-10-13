package com.example.aad22.ut01.ex03

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aad22.ut01.ex03.data.NewsLocalSource
import com.example.aad22.ut01.ex03.domain.News

class Ut01Ex03Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        val newsLocalSource = NewsLocalSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        fun initWithList(): MutableList<News>{
            val newsList = mutableListOf<News>(
                News(1,"Titulo1","Subtitulo1","Summary1"),
                News(2,"Titulo2","Subtitulo2","Summary2"),
                News(3,"Titulo3","Subtitulo3","Summary3")
            )
            return newsList
        }

        newsLocalSource.setNewsList(initWithList())
        newsLocalSource.getNewsMap()
    }

}