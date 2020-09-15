package com.reducelab.reducelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //El boton de atras
        btnProfileAtras.setOnClickListener {
            val intentAtras = android.content.Intent (this, GameActivity::class.java)
            startActivity(intentAtras)
            finish()
        }


    }
}