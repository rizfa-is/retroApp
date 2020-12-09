package com.istekno.retrokitapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(), View.OnClickListener {

    lateinit var mActivity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        onCreateInit()
    }

    override fun onClick(v: View) {
        onClickView(v)
    }

    abstract fun onCreateInit()

    open fun onClickView(v: View) {}
}