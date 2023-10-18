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
    private var nomeServico: String? = ""
    private var backgroundTag: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao_data_hora)

        // Atribuindo variaveis selectDate e selectTime
        onSelectDate()
        onSelectHora()

        // Atribuindo ao timerPicker apenas como Hora e Minuto
        setTimerPickHourAndMin()

        // Atribuindo as variaveis nomeServico e backgroundTag com as devidas intenções da HomeActivity
        getIntentAfterHomeScreen()

        // A função é autoexplicativa
        setContentTextAndImgIconAfterChooseServiceInSelecaoDataHoraActivity()


    }


    fun setContentTextAndImgIconAfterChooseServiceInSelecaoDataHoraActivity(){
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

    fun setTimerPickHourAndMin(){
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        timePicker.setIs24HourView(true)
    }

    fun getIntentAfterHomeScreen(){
        nomeServico = intent.getStringExtra("nomeServico").toString()
        backgroundTag = intent.getStringExtra("backgroundTag").toString()
    }

    fun onBackViewImageClicked(view: View){
        val intencao = Intent(this, HomeActivity::class.java)
        intencao.putExtra("voltaServico", nomeServico)
        intencao.putExtra("voltaBackgroundTag", backgroundTag)
        startActivity(intencao)
    }

    fun onSelectDate(){
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Quando a data é alterada, este código será chamado
            selectedDate = "$dayOfMonth/${month + 1}/$year" // Formate a data como desejar
            println("Data selecionada foi: $selectedDate")
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun onSelectHora() {
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            selectedTime = "$hourOfDay:$minute"
            println("Horário selecionado: $selectedTime")
        }
    }

    fun onButtonConfirmarAgendamentoIsClicked(view: View){
        val intencao = Intent(this, AgendaConcluidaActivity::class.java)
        /*intencao.putExtra("servicoToList", nomeServico)
        intencao.putExtra("dateToList", selectedDate)
        intencao.putExtra("timeToList", selectedTime)*/
        startActivity(intencao)
    }
}