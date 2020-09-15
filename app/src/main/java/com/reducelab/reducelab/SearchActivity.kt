package com.reducelab.reducelab

import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.view.*


class SearchActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.reducelab.reducelab.R.layout.activity_search)

        // Declarando las variables para el spinner
        val spin = spinId
        var arrayAdapter: ArrayAdapter<String> ? = null
        val itemList = arrayOf("Escoge un residuo para ver manualidades con este","Papel", "Revistas", "Tetrapack", "Icopor", "Botella de gaseosa", "Botella de champú", "Botella de detergente líquido", "Vaso de yogur", "Lata", "Tapas", "Rollo de papel higiénigo", "Paquete de mecato" )

        //El botón del edificio
        btnPuerta.setOnClickListener {
            val intentEdificio = android.content.Intent (this, EdificioActivity::class.java)
            startActivity(intentEdificio)
        }


        //El boton de atras
        btnSearchAtras.setOnClickListener {
            val intentAtras = Intent (this, MainActivity::class.java)
            startActivity(intentAtras)
            finish()
        }

        //Vamos a configurar cada botón para que aparezca en el textview la info

        btnCanecaVerde.setOnClickListener {

            txtView_infoCanecas.run {
                txtView_infoCanecas.setText("La caneca verde representa los residuos ordinarios, es decir, que no se pueden reciclar o aprocechar. Por ejemplo, el material orgánico, polvos, servilletas usadas, etc")
                txtView_infoCanecas.setBackgroundColor(Color.parseColor("#9A80CBC4"))
            }
        }

        btnCanecaGris.setOnClickListener {

            txtView_infoCanecas.run {
                txtView_infoCanecas.setText("En las canecas de reciclaje de color gris se depositan el cartón y el papel. ¡ATENCIÓN! es muy importante que estos deshechos estén limpios y sin residuos de algún líquido")
                txtView_infoCanecas.setBackgroundColor(Color.parseColor("#9A80CBC4"))
            }
        }

        btnCanecaAzul.setOnClickListener {

            txtView_infoCanecas.run {
                txtView_infoCanecas.setText("El azul es el color característico para los plásticos. En esta caneca puedes depositar todo tipo de envases de este material como botellas, vasos y bolsas.")
                txtView_infoCanecas.setBackgroundColor(Color.parseColor("#9A80CBC4"))
            }

        }
        btnCanecaCrema.setOnClickListener {

            txtView_infoCanecas.run {
                txtView_infoCanecas.setText("En las canecas color crema se depositan los residuos orgánicos. Algunos ejemplos son: Hojas de árboles y plantas, residuos de comida, papel sucio o no reciclable, entre otros.")
                txtView_infoCanecas.setBackgroundColor(Color.parseColor("#9A80CBC4"))
            }
        }

        // Invoco a firestore
        val db = FirebaseFirestore.getInstance()

        // Vamos a mostrar las opciones en el spinner
        arrayAdapter = ArrayAdapter(applicationContext, R.layout.simple_spinner_item, itemList)
        spin?.adapter = arrayAdapter

        spin?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Toast.makeText(applicationContext, "Nothing Select", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected( parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var item:String = parent?.getItemAtPosition(position) as String
                var residuo = item
                // #00FFFFFF

                val papel = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: origami dinosaurio, cisne de origami modular, origami máscara de lobo, lámpara de origami."
                val revistas = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: muebles, cestas, flores coloridas, cruz creativa"
                val tetrapack = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: cofre plateado, cajas de regalo, cestas, esfera navideña."
                val icopor = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: pacman con platos, llaveros de emoji, figuras de animales, corazones 3D."
                val botellaDeGaseosa = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: móvil de techo, macetas de conejo, flores para decorar, cofre."
                val botellaDeChampu = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: bisuteria, gato decorativo, portalapiz de muñeca, cosmetiquera."
                val botellaDeDetergenteLiquido = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: portavelas, servilletero de cisne, soporte para cargar teléfono, revistero"
                val vasoDeYogur = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: pulpo decorativo, teléfono con hilo, muñeco de nieve, campanas navideñas."
                val lata = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: cinturón con anillas, bolso, retrato 3D, portavelas."
                val tapas = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: instrumentos, muñeco, portavasos, trompo."
                val rolloDePapelHigienico = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: flores para la pared, castillo, monstruito con dulces, animales decoracion"
                val paqueteDeMecato = "¡Encuentra las imágenes en nuestra página web y más! Con este material puedes hacer: cartuchera, marco para fotos, portada cuaderno, estuche celular."

                txtView_infoCanecas.setBackgroundColor(Color.parseColor("#9A80CBC4"))

                when (residuo) {
                    "Papel" -> txtView_infoCanecas.setText(papel)
                    "Revistas" -> txtView_infoCanecas.setText(revistas)
                    "Tetrapack"-> txtView_infoCanecas.setText(tetrapack)
                    "Icopor"-> txtView_infoCanecas.setText(icopor)
                    "Botella de gaseosa" -> txtView_infoCanecas.setText(botellaDeGaseosa)
                    "Botella de champú" -> txtView_infoCanecas.setText(botellaDeChampu)
                    "Botella de detergente líquido" -> txtView_infoCanecas.setText(botellaDeDetergenteLiquido)
                    "Vaso de yogur" -> txtView_infoCanecas.setText(vasoDeYogur)
                    "Lata" -> txtView_infoCanecas.setText(lata)
                    "Tapas" -> txtView_infoCanecas.setText(tapas)
                    "Rollo de papel higiénigo" -> txtView_infoCanecas.setText(rolloDePapelHigienico)
                    "Paquete de mecato" -> txtView_infoCanecas.setText(paqueteDeMecato)

                    else -> {
                    }
                }



                //En esta parte la base de datos de Firestore mostrará los documentos de la colección
                var docRef = db.collection("residuos").document("Papel");

                /* ME CANSÉ DE QUE NO FUNCIONARA AAAAAAH
                docRef.get().addOnSuccessListener { document ->
                        if (document != null) {
                            val opcion1 = document.get("opcion1")
                            val opcion2 = document.get("opcion2")
                            val opcion3 = document.get("opcion3")
                            val opcion4 = document.get("opcion4")
                            val total = "Puedes hacer $opcion1" +
                                    " y $opcion2" +
                                    " y $opcion3" +
                                    " y $opcion4"
                            txtView_infoCanecas.setBackgroundColor(Color.parseColor("#9A80CBC4"))
                            txtView_infoCanecas.setText("FUNCIONÓ") //Pongo esto mientras para ver si funciona o no, luego pondría a total

                        }
                    }
                    .addOnFailureListener { exception ->
                        //txtView_infoCanecas.setBackgroundColor(Color.parseColor("#9A80CBC4"))
                        txtView_infoCanecas.setText("Esto no debería de aparecer")
                    } */




            }

        }


    }
}

