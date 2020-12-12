package com.istekno.retrokitapp.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.istekno.retrokitapp.R

class SplashScreenActivity() : BaseActivity() {

    private lateinit var baseActivity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        baseActivity = this
        baseActivity.view = R.layout.activity_splash_screen
        super.onCreate(savedInstanceState)

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