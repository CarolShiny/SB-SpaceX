package com.example.salaobelezaspacex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.salaobelezaspacex.view.Home

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun irHome(view: View){
        val intencao = Intent(this,Home::class.java)
        startActivity(intencao)
    }
}