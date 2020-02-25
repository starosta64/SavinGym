package com.example.savingym.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.savingym.R
import com.example.savingym.ui.launch.LoginActivity


class SplashActivity : AppCompatActivity() {

    companion object{
        private const val SPLASH_DISPLAY_LENGTH:Long = 2000
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            // По истечении времени, запускаем главный активити, а Splash закрываем
            val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            this@SplashActivity.finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}
