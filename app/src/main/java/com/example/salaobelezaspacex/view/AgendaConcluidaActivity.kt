package com.example.salaobelezaspacex.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.salaobelezaspacex.R


class AgendaConcluidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda_concluida)

    }
    fun irHome(view:View){
        val intencao = Intent(this, HomeActivity::class.java)
        startActivity(intencao)
    }
}