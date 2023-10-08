package com.example.salaobelezaspacex.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.salaobelezaspacex.R
import com.example.salaobelezaspacex.adapter.ServicosAdapter
import com.example.salaobelezaspacex.databinding.ActivityHomeBinding
import com.example.salaobelezaspacex.model.Servicos
import com.example.salaobelezaspacex.MainActivity

class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding


    private var selectService: String? = null


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

        /*val btnAgendar = findViewById<Button>(R.id.btAgendar)
        val radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup1)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)

        btnAgendar.setOnClickListener(View.OnClickListener {
            // Lógica de seleção para radioGroup1

            val selectedRadioButtonId1 = radioGroup1.checkedRadioButtonId
            when (selectedRadioButtonId1) {
                R.id.radioButton1 -> {
                    // Faça algo com a seleção do radioButton1 de radioGroup1
                    print("Radio Button 11111 selecionado")
                    println()
                    val radioButton1 = findViewById<RadioButton>(R.id.radioButton1)
                    val textRadioButton1 = radioButton1.contentDescription
                    println(textRadioButton1)

                }
                R.id.radioButton2 -> {
                    // Faça algo com a seleção do radioButton2 de radioGroup1
                    print("Radio Button 22222 selecionado")
                    println()
                    val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
                    val textRadioButton2 = radioButton2.contentDescription
                    println(textRadioButton2)

                }
                // Outros casos para radioGroup1
            }

            // Lógica de seleção para radioGroup2
            val selectedRadioButtonId2 = radioGroup2.checkedRadioButtonId
            when (selectedRadioButtonId2) {
                R.id.radioButton3 -> {
                    // Faça algo com a seleção do radioButton3 de radioGroup2
                    print("Radio Button 33333 selecionado")
                    println()
                    val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)
                    val textRadioButton3 = radioButton3.contentDescription
                    println(textRadioButton3)

                }
                R.id.radioButton4 -> {
                    // Faça algo com a seleção do radioButton4 de radioGroup2
                    print("Radio Button 4444444 selecionado")
                    println()
                    val radioButton4 = findViewById<RadioButton>(R.id.radioButton4)
                    val textRadioButton4 = radioButton4.contentDescription
                    println(textRadioButton4)
                }
                // Outros casos para radioGroup2
            }
        })*/
    }



    // Função para tratar o clique no RadioButton 1 (Lavagem de cabelo)
    fun onRadioButton1Clicked(view: View) {
        selectService = "Lavagem de cabelo"
        println(selectService)
    }

    // Função para tratar o clique no RadioButton 2 (Tratamento de cabelo)
    fun onRadioButton2Clicked(view: View) {
        selectService = "Tratamento de cabelo"
        println(selectService)

    }

    // Função para tratar o clique no RadioButton 3 (Corte de cabelo)
    fun onRadioButton3Clicked(view: View) {
        selectService = "Corte de cabelo"
        println(selectService)


    }

    // Função para tratar o clique no RadioButton 4 (Manicure)
    fun onRadioButton4Clicked(view: View) {
        selectService = "Manicure"
        println(selectService)

    }

    fun onAgendarClicked(view: View){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("nomeServico", selectService)
        startActivity(intent)
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
