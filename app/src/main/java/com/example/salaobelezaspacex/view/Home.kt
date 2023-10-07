package com.example.salaobelezaspacex.view

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

class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()

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

        val btnAgendar = findViewById<Button>(R.id.btAgendar)
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
                    val textRadioButton1 = radioButton1.text
                    println(textRadioButton1)

                }
                R.id.radioButton2 -> {
                    // Faça algo com a seleção do radioButton2 de radioGroup1
                    print("Radio Button 22222 selecionado")
                    println()
                    val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
                    val textRadioButton2 = radioButton2.text
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
                    val textRadioButton3 = radioButton3.text
                    println(textRadioButton3)

                }
                R.id.radioButton4 -> {
                    // Faça algo com a seleção do radioButton4 de radioGroup2
                    print("Radio Button 4444444 selecionado")
                    println()
                    val radioButton4 = findViewById<RadioButton>(R.id.radioButton4)
                    val textRadioButton4 = radioButton4.text
                    println(textRadioButton4)
                }
                // Outros casos para radioGroup2
            }
        })
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
