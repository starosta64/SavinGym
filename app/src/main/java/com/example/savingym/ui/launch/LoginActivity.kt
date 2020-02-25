package com.example.savingym.ui.launch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.savingym.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FirstStepFragment())
            .addToBackStack(null)
            .commit()
    }
}
