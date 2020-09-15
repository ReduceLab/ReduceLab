package com.reducelab.reducelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Esto se hace porque cuando se abra la EntryActivity, no queremos que se devuelva
        val newIntent = android.content.Intent (this, EntryActivity::class.java)
        startActivity(newIntent)
        finish()
    }
}