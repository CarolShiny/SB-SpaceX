package com.example.salaobelezaspacex

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.salaobelezaspacex.databinding.ActivityMainBinding
import com.example.salaobelezaspacex.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btLogin.setOnClickListener {
            val usuario = binding.editUsuario.text.toString()
            val senha = binding.editSenha.text.toString()

            when{
                usuario.isEmpty() -> {
                    mensagem(it, "Coloque o seu usuário!")
                }senha.isEmpty() ->{
                    mensagem(it,"Preencha a senha!")
                }senha.length<=5 ->{
                    mensagem(it, "A senha precisa ter pelo menos 6 caracteres")
                } else ->{
                    irHome(usuario)

                }

            }
        }
    }

    private fun mensagem (view: View, mensagem: String){
        val snackbar = Snackbar.make(view,mensagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setActionTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }


    fun irHome(nome: String ){
        val intencao = Intent(this,Home::class.java)
        intencao.putExtra("nome", nome)
        startActivity(intencao)
    }
}