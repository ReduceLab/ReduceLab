package com.reducelab.reducelab

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Point
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        //El boton de atras
        btnGameAtras.setOnClickListener {
            val intentAtras = android.content.Intent (this, MainActivity::class.java)
            startActivity(intentAtras)
            finish()
        }

        //El boton de perfil
        btnPerfil.setOnClickListener {
            val intentPerfil = android.content.Intent (this, ProfileActivity::class.java)
            startActivity(intentPerfil)
            finish()
        }

        //Definir la variable que guardará el puntaje
        var puntaje = 0

        //Vamos a decir que cada una de las imagenes estará pendiente del LongClick
        manzana.setOnLongClickListener(longClickListener)
        vaso.setOnLongClickListener(longClickListener)
        mecato.setOnLongClickListener(longClickListener)
        botella.setOnLongClickListener(longClickListener)
        gaseosa.setOnLongClickListener(longClickListener)
        banano.setOnLongClickListener(longClickListener)
        bolsa.setOnLongClickListener(longClickListener)
        caja.setOnLongClickListener(longClickListener)
        periodico.setOnLongClickListener(longClickListener)
        revista.setOnLongClickListener(longClickListener)


        //Vamos a decir que las canecas estarán pendientes si les arrastraron correctamente
        canecaVerde.setOnDragListener(dragListener)
        canecaAzul.setOnDragListener(dragListener)
        canecaGris.setOnDragListener(dragListener)

        val correcto = "¡Muy bien!"
        val incorrecto = "¡Nooo!"

        if (statusTextView.text == correcto) {
            puntaje += 1
            TxtPuntaje.setText(puntaje)

        }
        if (statusTextView.text == incorrecto ){
            TxtPuntaje.setText(puntaje)
            //cambiar lo de las vidas
        }

    }
    // Drag and Drop de las imágenes a los layouts
    //La clase ShadowBuilder convierte la imagen que le des (entrada) y te va a dar una sombre

    private class MyDragShadowBuilder(val v: View) : View.DragShadowBuilder(v) {

        override fun onProvideShadowMetrics(size: Point, touch: Point) {
            size.set(view.width, view.height) //El punto de entrada es el tamaño de la imagen
            touch.set(view.width / 2, view.height / 2) //Vamos a establecer que el touch sea la mitad del objeto
        }
        override fun onDrawShadow(canvas: Canvas) {
            v.draw(canvas)
        }
    }
    private val longClickListener = View.OnLongClickListener { v ->
        //Acá estams estableciendo la información que le vamos a dar al DragAndDrop
        val item = ClipData.Item(v.tag as? CharSequence)

        val dragData = ClipData(
            v.tag as CharSequence,
            arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
            item
        )

        //Esta es la sombra que va  allevar el DragAndDrop
        val myShadow = MyDragShadowBuilder(v)

        //Acá estamos diciendo que dependiendo de la versión de android va a hacer una de estas
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            v.startDragAndDrop(dragData, myShadow,null,0)

        } else {
            v.startDrag(dragData, myShadow,null,0)
        }
        v.visibility = View.INVISIBLE

        true
    }

    //Este es el evento que va a estar escuchando en el momento de estar arrastrando
    private val dragListener = View.OnDragListener { v, event ->
        val receiverView:ImageView = v as ImageView

        when (event.action) {
            android.view.DragEvent.ACTION_DRAG_STARTED -> {
                //Esto es cuando se está arrastrando la figura
                true
            }

            android.view.DragEvent.ACTION_DRAG_ENTERED -> {
                //Cuando lo que estás arrastrando entra dentro de la vista que está escuchando

                //Acá estoy verificando si la etiqueta de las imágenes va a corresponder con la otra por medio de la TAG
                if(event.clipDescription.label == receiverView.tag as String) {
                    statusTextView.text = "¡Muy bien!"

                } else {
                    statusTextView.text = "¡Nooo!"
                }
                v.invalidate()
                true
            }

            android.view.DragEvent.ACTION_DRAG_LOCATION ->
                //La ubicación del arrastre
                true

            android.view.DragEvent.ACTION_DRAG_EXITED -> {
                //Cuando lo que estás arrasrando sale de la imagen que corresponda

                //Acá estoy verificando si la etiqueta de las imágenes va a corresponder con la otra por medio de la TAG
                if(event.clipDescription.label == receiverView.tag as String) {
                    v.invalidate()
                }
                true
            }

            android.view. DragEvent.ACTION_DROP -> {
                //Cuando sueltas lo que estás arrastrando
                //Vamos a hacer que de verdad el item se mueva al layout, i guess
               /* val cosito = event.localState as View
                val owner = cosito.parent as ViewGroup
                owner.removeView(cosito)*/
                true
            }

            android.view.DragEvent.ACTION_DRAG_ENDED -> {
                //Cuando dejas de arrastrar
                true
            }

            else -> {
                false
            }
        }
    }

}


