package com.reducelab.reducelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_entry.*

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        // Vamos a abrir la nueva actividad
        btn.setOnClickListener {
            val intent = android.content.Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}