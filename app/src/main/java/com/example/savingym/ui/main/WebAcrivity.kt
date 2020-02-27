package com.example.savingym.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.savingym.R

class WebAcrivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_acrivity)

        supportFragmentManager.beginTransaction()
            .replace(R.id.web_container, WebFragment())
            .addToBackStack(null)
            .commit()
    }


}
