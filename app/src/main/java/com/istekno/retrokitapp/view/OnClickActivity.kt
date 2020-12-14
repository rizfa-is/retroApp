package com.istekno.retrokitapp.view

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.istekno.retrokitapp.R
import com.istekno.retrokitapp.calculator.EqualEraseOperations
import com.istekno.retrokitapp.calculator.MathematicOperations
import com.istekno.retrokitapp.rolldice.RollDice

open class OnClickActivity : EqualEraseOperations() {

    private fun onCLickHome(context: Context, v: View) {
        val listButton = intArrayOf(R.id.img_home_dice, R.id.tv_home_dice, R.id.img_home_calculator, R.id.tv_home_calculator)
        val listClass = arrayOf(RollDiceActivity::class.java, CalculatorActivity::class.java)

        for (i in listButton.indices) {
            if (v.id == listButton[i]) {
                val index = listButton.indexOf(v.id)
                val classActivity = if (index <=1) listClass[0] else listClass[1]
                context.startActivity(Intent(context, classActivity))
            }
        }
    }

    private fun onClickRollDice(v: View, imageView: ImageView, context: Context) {
        val rollDice = RollDice()
        if (v.id == R.id.btn_roll) rollDice.rollDice(imageView, context)
    }

    private fun onClickCalculator(context: Context, v: View, tvCalculate: TextView, tvResult: TextView) {
        val mathematicOperations = MathematicOperations()
        val listStr = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "", "(", ")", "/", "*", "-", "+", "%", "^", "sqrt(")
        val listButton = intArrayOf(
                R.id.num0, R.id.num1, R.id.num2, R.id.num3, R.id.num4,
                R.id.num5, R.id.num6, R.id.num7, R.id.num8, R.id.num9,
                R.id.numDot, R.id.clear, R.id.openBracket, R.id.closeBracket, R.id.actionDivide,
                R.id.actionMultiply, R.id.actionMinus, R.id.actionPlus, R.id.actionModulo, R.id.actionQuadratic, R.id.actionSquareRoot)
        val listButton2 = arrayOf(R.id.actionBack, R.id.actionEquals)

        when (v.id) {
            in listButton -> {
                mathematicOperations.actionGeneral(listButton, listStr, v, tvCalculate, tvResult)
            }
            in listButton2 -> {
                if (v.id == listButton2[0]) actionBackListener(tvCalculate) else actionEqualsListener(tvCalculate, tvResult, context)
            }
        }
    }

    override fun actionBackListener(tvCalculate: TextView) {
        val expression = tvCalculate.text.toString()
        if (expression.isNotEmpty()) {
            tvCalculate.text = expression.substring(0, expression.length - 1)
        }
    }

    fun getOnCLick(context: Context, v: View) {
        return onCLickHome(context, v)
    }

    fun getOnCLick(context: Context, v: View, imageView: ImageView) {
        return onClickRollDice(v, imageView, context)
    }

    fun getOnCLick(context: Context, v: View, tvCalculate: TextView, tvResult: TextView) {
        return onClickCalculator(context, v, tvCalculate, tvResult)
    }
}