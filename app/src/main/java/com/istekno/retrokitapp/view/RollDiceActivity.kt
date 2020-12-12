package com.istekno.retrokitapp.view

import android.os.Bundle
import android.view.View
import com.istekno.retrokitapp.R
import kotlinx.android.synthetic.main.activity_roll_dice.*

class RollDiceActivity : BaseActivity() {

    private lateinit var baseActivity: BaseActivity
    private lateinit var onClickActivity: OnClickActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        baseActivity = this
        baseActivity.view = R.layout.activity_roll_dice
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
    }

    override fun onClick(v: View) {
        onClickActivity = OnClickActivity()
        onClickActivity.getOnCLickDice(v, img_roll, this)
    }
}
