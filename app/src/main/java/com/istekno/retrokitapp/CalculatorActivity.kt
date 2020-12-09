package com.istekno.retrokitapp

import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.sqrt

class CalculatorActivity : BaseActivity() {

    override fun onCreateInit() {
        setContentView(R.layout.activity_calculator)
        supportActionBar?.hide()

        num0.setOnClickListener(this)
        num1.setOnClickListener(this)
        num2.setOnClickListener(this)
        num3.setOnClickListener(this)
        num4.setOnClickListener(this)
        num5.setOnClickListener(this)
        num6.setOnClickListener(this)
        num7.setOnClickListener(this)
        num8.setOnClickListener(this)
        num9.setOnClickListener(this)
        numDot.setOnClickListener(this)

        clear.setOnClickListener(this)
        openBracket.setOnClickListener(this)
        closeBracket.setOnClickListener(this)
        actionDivide.setOnClickListener(this)
        actionMultiply.setOnClickListener(this)
        actionMinus.setOnClickListener(this)
        actionPlus.setOnClickListener(this)
        actionSquareRoot.setOnClickListener(this)
        actionModulo.setOnClickListener(this)
        actionQuadratic.setOnClickListener(this)

        actionBack.setOnClickListener(this)
        actionEquals.setOnClickListener(this)
    }

    override fun onClickView(v: View) {
        val listButton = intArrayOf(
            R.id.num0, R.id.num1, R.id.num2, R.id.num3, R.id.num4,
            R.id.num5, R.id.num6, R.id.num7, R.id.num8, R.id.num9,
            R.id.numDot, R.id.clear, R.id.openBracket, R.id.closeBracket, R.id.actionDivide,
            R.id.actionMultiply, R.id.actionMinus, R.id.actionPlus, R.id.actionModulo, R.id.actionQuadratic, R.id.actionSquareRoot)
        val listStr = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "", " ( ", " ) ", " / ", " * ", " - ", " + ", " % ", " ^ ", " sqrt( ")

        when (v.id) {
            in listButton -> {
                actionGeneral(listButton, listStr, v)
            }
            R.id.actionBack -> {
                actionBackListener()
            }
            R.id.actionEquals -> {
                actionEqualsListener()
            }
        }
    }

    private fun actionGeneral(listButton: IntArray, listStr: Array<String>, view: View) {
        val index = listButton.indexOf(view.id)
        val str = listStr[index]
        var isClear = false
        if (str == "") isClear = true

        appendCalc(str, isClear)
    }

    private fun actionBackListener() {
        val expression = tv_calc_calculation.text.toString()
        if (expression.isNotEmpty()) {
            tv_calc_calculation.text = expression.substring(0, expression.length - 1)
        }
    }

    private fun actionEqualsListener() {
        try {
            val expression = ExpressionBuilder(tv_calc_calculation.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tv_calc_result.text = "= $longResult"
            } else {
                tv_calc_result.text = result.toString()
            }
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            Log.d("EXCEPTION", "Message: ${e.message}")
        }
    }

    private fun appendCalc(string: String, isClear: Boolean) {
        if (isClear) {
            tv_calc_calculation.text = ""
            tv_calc_result.text = "= "
        } else {
            tv_calc_calculation.append(string)
        }
    }
}