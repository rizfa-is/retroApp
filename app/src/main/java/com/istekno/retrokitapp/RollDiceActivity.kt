package com.istekno.retrokitapp

import android.view.View
import kotlinx.android.synthetic.main.activity_roll_dice.*
import java.util.*

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
        val randomNumber = Random().nextInt(6) + 1
        val imageResources = when (randomNumber) {
            1 -> R.drawable.img_dice_1
            2 -> R.drawable.img_dice_2
            3 -> R.drawable.img_dice_3
            4 -> R.drawable.img_dice_4
            5 -> R.drawable.img_dice_5
            else -> R.drawable.img_dice_6
        }
        img_roll.setImageResource(imageResources)
    }


}
