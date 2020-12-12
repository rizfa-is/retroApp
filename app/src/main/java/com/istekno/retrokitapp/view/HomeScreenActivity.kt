package com.istekno.retrokitapp.view

import android.os.Bundle
import android.view.View
import com.istekno.retrokitapp.R

class HomeScreenActivity : BaseActivity() {

    private lateinit var baseActivity: BaseActivity
    private lateinit var onClickActivity: OnClickActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        baseActivity = this
        baseActivity.view = R.layout.activity_home_screen
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
    }

    override fun onClick(v: View) {
        onClickActivity = OnClickActivity()
        onClickActivity.getOnCLickHome(this, v)
    }
}