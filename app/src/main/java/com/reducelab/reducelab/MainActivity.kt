package com.reducelab.reducelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_entry.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Vamos a programar la apertura de cada una de las actividades de acuerdo al boton  jugar, instrucciones de juego, Buscador, quiénes somos, cerrar sesión
        btnJugar.setOnClickListener {
            val intentJugar = android.content.Intent (this, GameActivity::class.java)
            startActivity(intentJugar)
        }
        btnInstrucciones.setOnClickListener {
            val intentInst = android.content.Intent (this, InstActivity::class.java)
            startActivity(intentInst)
        }
        btnBuscador.setOnClickListener {
            val intentBuscar = android.content.Intent (this, SearchActivity::class.java)
            startActivity(intentBuscar)
        }
        btnQuienesSomos.setOnClickListener {
            val intentQnsms = android.content.Intent (this, PresentationActivity::class.java)
            startActivity(intentQnsms)
        }
        btnCerrarSesion.setOnClickListener {
            val intentCerrar = android.content.Intent (this, EntryActivity::class.java)
            startActivity(intentCerrar)
        }
    }
}