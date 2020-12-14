package com.istekno.retrokitapp.view

import android.os.Bundle
import android.view.View
import com.istekno.retrokitapp.R

class HomeScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val baseActivity = this
        baseActivity.view = R.layout.activity_home_screen
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
    }

    override fun onClick(v: View) {
        val onClickActivity = OnClickActivity()
        onClickActivity.getOnCLick(this, v)
    }
}