package com.istekno.retrokitapp.calculator

import android.content.Context
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

abstract class EqualEraseOperations {

    fun actionEqualsListener(tvCalculate: TextView, tvResult: TextView, context: Context) {
        try {
            val expression = ExpressionBuilder(tvCalculate.text.toString()).build().evaluate()
            val longResult = expression.toLong()
            if (expression == longResult.toDouble()) {
                tvResult.text = "$longResult"
            } else {
                tvResult.text = expression.toString()
            }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    abstract fun actionBackListener(tvCalculate: TextView)
}