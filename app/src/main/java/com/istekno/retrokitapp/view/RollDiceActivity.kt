package com.istekno.retrokitapp.view

import android.os.Bundle
import android.view.View
import com.istekno.retrokitapp.R
import kotlinx.android.synthetic.main.activity_roll_dice.*

class RollDiceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val baseActivity = this
        baseActivity.view = R.layout.activity_roll_dice
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
    }

    override fun onClick(v: View) {
        val onClickActivity = OnClickActivity()
        onClickActivity.getOnCLick(this, v, img_roll)
    }
}
