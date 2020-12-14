package com.istekno.retrokitapp.view

import android.os.Bundle
import android.view.View
import com.istekno.retrokitapp.R
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val baseActivity = this
        baseActivity.view = R.layout.activity_calculator
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
    }

    override fun onClick(v: View) {
        val onClickActivity = OnClickActivity()
        onClickActivity.getOnCLick(this, v, tv_calc_calculation, tv_calc_result)
    }
}