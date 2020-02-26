package com.example.savingym.ui.launch

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.savingym.R
import com.example.savingym.ui.launch.auth.LoginFragment
import com.example.savingym.ui.launch.splash.FirstStepFragment

class LoginActivity : AppCompatActivity() {

    companion object {
        private const val APP_PREFERENCES = "mysettings"
        private const val USER_GENDER = "user_gender"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        if (mSettings.contains(USER_GENDER)) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    LoginFragment()
                )
                .addToBackStack(null)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    FirstStepFragment()
                )
                .addToBackStack(null)
                .commit()
        }
    }
}
