package com.istekno.retrokitapp

import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_roll_dice.*

class RollDiceActivity : BaseActivity() {

    override fun onCreateInit() {
        setContentView(R.layout.activity_roll_dice)
        supportActionBar?.hide()

        btn_roll.setOnClickListener(this)
    }

    override fun onClickView(v: View) {
        when (v.id) {
            R.id.btn_roll -> {
                rollDice()
            }
        }
    }

    private fun rollDice() {
        val listNumber = intArrayOf(1, 2, 3, 4, 5, 6)
        val listDice = intArrayOf(R.drawable.img_dice_1, R.drawable.img_dice_2, R.drawable.img_dice_3, R.drawable.img_dice_4, R.drawable.img_dice_5, R.drawable.img_dice_6)
        val random = (1..6).random()

        val imageResources = when (random) {
            in listNumber -> {
                listDice[listNumber.indexOf(random)]
            }
            else -> R.drawable.ic_dice_box
        }
        img_roll.setImageResource(imageResources)
    }
}
