package com.reducelab.reducelab

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edificio.*
import kotlinx.android.synthetic.main.activity_search.txtView_infoCanecas
import kotlinx.android.synthetic.main.activity_search.view.*

class EdificioActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edificio)

        //El boton de atras
        btnEdiAtras.setOnClickListener {
            val intentAtras = android.content.Intent (this, SearchActivity::class.java)
            startActivity(intentAtras)
            finish()
        }

        //Vamos a configurar cada botón para que aparezca en el textview la info

        btnCanecaBlanca.setOnClickListener {

            textView_infoCanecas2.run {

                textView_infoCanecas2.setText("El color blanco es característico de la caneca en la que se deposita el vidrio color verde, ámbar y transparente, evitando que se rompa. No se debe depositar el vidrio plano, por ejemplo de las ventanas o espejos")
                textView_infoCanecas2.setBackgroundColor(Color.parseColor("#9A80CBC4"))
            }
        }
        btnCanecaRoja.setOnClickListener {

            textView_infoCanecas2.run {
                textView_infoCanecas2.setText("Las canecas rojas se caracterizan por ser las que contienen productos de riesgo biológico, tales como materiales de curación o materiales corrosivos y tóxicos. Esta caneca solo puede estar ubicada en sitios autorizados.")
                textView_infoCanecas2.setBackgroundColor(Color.parseColor("#9A80CBC4"))
            }
        }
        btnCanecaNaranja.setOnClickListener {

            textView_infoCanecas2.run {
                textView_infoCanecas2.setText("La caneca naranja es aquella donde se deshecha aceite usado domestico EMPAQUETADO. De este modo, se podrá reciclar el aceite usado y darle nuevos usos como la fabricación de combustible biodiésel.")
                textView_infoCanecas2.setBackgroundColor(Color.parseColor("#9A80CBC4"))
            }
        }
        btnCanecaAmarilla.setOnClickListener {

            textView_infoCanecas2.run {
                textView_infoCanecas2.setText("La caneca amarilla es poco común, pero en ella se depositan eesiduos metálicos, chatarra, latas de bebidas y alimentos, aluminio y cobre.")
                textView_infoCanecas2.setBackgroundColor(Color.parseColor("#9A80CBC4"))
            }
        }

    }
}