package com.istekno.retrokitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreenActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        supportActionBar?.hide()

        img_home_dice.setOnClickListener(this)
        img_home_calculator.setOnClickListener(this)
        tv_home_dice.setOnClickListener(this)
        tv_home_calculator.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_home_dice -> {
                startActivity(Intent(this, RollDiceActivity::class.java))
            }
            R.id.tv_home_dice -> {
                startActivity(Intent(this, RollDiceActivity::class.java))
            }
            R.id.img_home_calculator -> {
                startActivity(Intent(this, CalculatorActivity::class.java))
            }
            R.id.tv_home_calculator -> {
                startActivity(Intent(this, CalculatorActivity::class.java))
            }
        }
    }
}