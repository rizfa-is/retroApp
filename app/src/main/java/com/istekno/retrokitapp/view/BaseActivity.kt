package com.istekno.retrokitapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(), View.OnClickListener {

    private lateinit var mActivity: AppCompatActivity
    var view : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view)
        mActivity = this
    }

    override fun onClick(v: View) {
    }
}