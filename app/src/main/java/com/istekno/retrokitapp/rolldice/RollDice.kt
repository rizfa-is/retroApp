package com.istekno.retrokitapp.rolldice

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.istekno.retrokitapp.R
import android.os.Handler
import android.os.Looper

class RollDice {

    private fun rollDice(img_roll: ImageView, context: Context) {
        val listNumber = intArrayOf(1, 2, 3, 4, 5, 6)
        val listDice = intArrayOf(R.drawable.img_dice_1, R.drawable.img_dice_2, R.drawable.img_dice_3, R.drawable.img_dice_4, R.drawable.img_dice_5, R.drawable.img_dice_6)

        when (val random = (1..6).random()) {
            in listNumber -> {
                Glide.with(context).load(R.drawable.animate_dice).into(img_roll)
                Handler(Looper.getMainLooper()).postDelayed(
                        {
                            img_roll.setImageResource(listDice[listNumber.indexOf(random)])
                        }, 1500
                )
            }
            else -> img_roll.setImageResource(R.drawable.ic_dice_box)
        }
    }

    fun getRollDice(img_roll: ImageView, context: Context) = rollDice(img_roll, context)
}