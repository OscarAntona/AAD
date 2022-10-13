package com.example.aad22.ut01.ex07.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.antgut.aad.R
import com.example.aad22.ut01.ex07.data.LocalDataSource
import com.example.aad22.ut01.ex07.domain.Contador


class Ut01Ex07Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex07)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val localSource = LocalDataSource(sharedPref)

        val palabra = findViewById<TextView>(R.id.palabra)
        var contador = findViewById<TextView>(R.id.contador)
        var mensaje = findViewById<TextView>(R.id.mensaje)

        if(localSource.getCounter(1) == null){
            localSource.saveCounter(Contador(1,1))
            var num = localSource.getCounter(1)?.contador.toString()
            contador.setText(num)
        }else{
            val counter = localSource.getCounter(1)
            if (counter != null) {
                if(counter.contador==2){
                    var num = localSource.getCounter(1)?.contador.toString()
                    contador.setText((num.toInt()+1).toString())
                    mensaje.text = "\"Se abrio ${num.toInt()+1} veces\""
                }else{
                    counter.contador = counter.contador + 1
                    localSource.saveCounter(counter)
                    var num = localSource.getCounter(1)?.contador.toString()
                    contador.setText(num)
                }
            }
        }
    }
}