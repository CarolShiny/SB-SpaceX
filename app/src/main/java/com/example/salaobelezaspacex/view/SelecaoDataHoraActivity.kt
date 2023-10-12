package com.example.salaobelezaspacex.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import com.example.salaobelezaspacex.R

class SelecaoDataHoraActivity : AppCompatActivity() {


    private var selectedDate: String? = null
    private var selectedTime: String? = null
    private var nomeServico: String = ""
    private var backgroundTag: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao_data_hora)



        val calendarView = findViewById<CalendarView>(R.id.calendarView)

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Quando a data é alterada, este código será chamado
            selectedDate = "$dayOfMonth/${month + 1}/$year" // Formate a data como desejar
            println("Data selecionada foi: $selectedDate")
        }


        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        timePicker.setIs24HourView(true)

        // Recebendo a intenção/variavel com a opção selecionada -- recebendo nome do serviço e a imagem como Tag para ser tratada
        /*val nomeServico = intent.getStringExtra("nomeServico")
        val backgroundTag = intent.getStringExtra("backgroundTag")*/
        getIntentBeforeScreen()

        //Atribuindo e comparando a backgroundTag se ela existe no package do drawnable que é onde ficam todas as imagens
        val backgroundResourceId = resources.getIdentifier(backgroundTag, "drawable", packageName)

        // Tratando do nome do texto que sera exibido de acordo com o botão que foi selecionado antes
        val textServiceName = findViewById<TextView>(R.id.textViewServiceName)
        textServiceName.setText(nomeServico.toString())
        println(textServiceName.text)

        // Tratando do background que sera exibido de acordo com o botão que foi selecionado antes
        val imageBackground = findViewById<ImageView>(R.id.imageViewBackground)
        imageBackground.setBackgroundResource(backgroundResourceId)

    }


    fun getIntentBeforeScreen(){
        nomeServico = intent.getStringExtra("nomeServico").toString()
        backgroundTag = intent.getStringExtra("backgroundTag").toString()
    }

    fun onBackViewImageClicked(view: View){
        println("ACABOU DE TENTAR VOLTAR")
        val intencao = Intent(this, Home::class.java)
        intencao.putExtra("voltaServico", nomeServico)
        intencao.putExtra("voltaBackgroundTag", backgroundTag)
        startActivity(intencao)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun onSelectHora(view: View) {
        val horaSelect = findViewById<TimePicker>(R.id.timePicker)
        selectedTime = "${horaSelect.hour}:${horaSelect.minute}"
        println("Horário selecionado: $selectedTime")
    }
}