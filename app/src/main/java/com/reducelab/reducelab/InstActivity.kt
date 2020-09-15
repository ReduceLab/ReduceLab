package com.reducelab.reducelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_inst2.*

class InstActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inst2)

        //El boton de atras
        btnInstAtras.setOnClickListener {
            val intentAtras = android.content.Intent (this, MainActivity::class.java)
            startActivity(intentAtras)
            finish()
        }


    }
}