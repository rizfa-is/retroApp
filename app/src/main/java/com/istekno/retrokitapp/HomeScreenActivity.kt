package com.istekno.retrokitapp

import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreenActivity : BaseActivity() {

    override fun onCreateInit() {
        setContentView(R.layout.activity_home_screen)
        supportActionBar?.hide()

        img_home_dice.setOnClickListener(this)
        img_home_calculator.setOnClickListener(this)
        tv_home_dice.setOnClickListener(this)
        tv_home_calculator.setOnClickListener(this)
    }

    override fun onClickView(v: View) {
        val listButton = intArrayOf(R.id.img_home_dice, R.id.tv_home_dice, R.id.img_home_calculator, R.id.tv_home_calculator)
        val listClass = arrayOf(RollDiceActivity::class.java, CalculatorActivity::class.java)

        when (v.id) {
            in listButton -> {
                val index = listButton.indexOf(v.id)
                val classActivity: Class<out BaseActivity>
                classActivity = if (index <=1) {
                    listClass[0]
                } else {
                    listClass[1]
                }

                startActivity(Intent(this, classActivity))
            }
        }
    }
}