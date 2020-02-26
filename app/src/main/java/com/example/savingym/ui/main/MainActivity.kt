package com.example.savingym.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.savingym.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_container,
                MainFragment()
            )
            .addToBackStack(null)
            .commit()
    }


}
