package com.reducelab.reducelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_presentation.*

class PresentationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)
        //El boton de atras
        btnAtrasQnsms.setOnClickListener {
            val intentAtras = android.content.Intent (this, MainActivity::class.java)
            startActivity(intentAtras)
            finish()
        }
    }
}