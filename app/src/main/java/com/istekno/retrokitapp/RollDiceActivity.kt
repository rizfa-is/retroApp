package com.istekno.retrokitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_roll_dice.*
import java.util.*

class RollDiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roll_dice)
        supportActionBar?.hide()

        btn_roll.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val randomNumber = Random().nextInt(6) + 1
        val imageResources = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        img_roll.setImageResource(imageResources)
    }
}
