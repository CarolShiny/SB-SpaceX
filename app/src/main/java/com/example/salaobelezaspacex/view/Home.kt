package com.example.salaobelezaspacex.view

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.salaobelezaspacex.R
import com.example.salaobelezaspacex.databinding.ActivityHomeBinding
import java.util.*

class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding


    private var nomeService: String = ""
    private var imgBackground: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarHome.toolbar)

        binding.appBarHome.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }


    //Função para capturar nome do serviço e o background
    fun nomeServicoAndimgBackground(valor: RadioButton){
        nomeService = valor.contentDescription.toString()
        imgBackground = valor.tag as String
    }

    // Função para tratar o clique no RadioButton 1 (Lavagem de cabelo)
    fun onRadioButton1Clicked(view: View) {
        nomeServicoAndimgBackground(findViewById<RadioButton>(R.id.radioButton1))
    }

    // Função para tratar o clique no RadioButton 2 (Tratamento de cabelo)
    fun onRadioButton2Clicked(view: View) {
        nomeServicoAndimgBackground(findViewById<RadioButton>(R.id.radioButton2))
    }

    // Função para tratar o clique no RadioButton 3 (Corte de cabelo)
    fun onRadioButton3Clicked(view: View) {
        nomeServicoAndimgBackground(findViewById<RadioButton>(R.id.radioButton3))
    }

    // Função para tratar o clique no RadioButton 4 (Manicure)
    fun onRadioButton4Clicked(view: View) {
        nomeServicoAndimgBackground(findViewById<RadioButton>(R.id.radioButton4))
    }

    fun onAgendarClicked(view: View){

        if (nomeService.isEmpty() && imgBackground.isEmpty()){
            val customMessageTextView = findViewById<TextView>(R.id.customCardTextView) // Substitua com a referência ao seu TextView personalizado
            customMessageTextView.text = "Selecione ao menos um serviço"
            val view = findViewById<CardView>(R.id.customCardView)
            view.visibility = View.VISIBLE
            object : CountDownTimer(4000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    // Este método é chamado a cada segundo, você pode atualizar o texto do timer aqui se desejar
                }

                override fun onFinish() {
                    view.visibility = View.GONE // Torna o TextView invisível após o término do timer (3 segundos)
                }
            }.start()



        }else{
            val intent = Intent(this, SelecaoDataHoraActivity::class.java)
            intent.putExtra("nomeServico", nomeService)
            intent.putExtra("backgroundTag", imgBackground)
            startActivity(intent)
        }

        if (intent.hasExtra("voltaServico") && intent.hasExtra("voltaBackgroundTag")) {
            nomeService = ""
            imgBackground = ""
        } else {}
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
