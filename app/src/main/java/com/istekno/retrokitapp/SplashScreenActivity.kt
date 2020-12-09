package com.istekno.retrokitapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashScreenActivity() : BaseActivity() {

    override fun onCreateInit() {
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )

        Handler(mainLooper).postDelayed(
            {
                startActivity(Intent(this, HomeScreenActivity::class.java))
                finish()
            }, 1000
        )
    }
}