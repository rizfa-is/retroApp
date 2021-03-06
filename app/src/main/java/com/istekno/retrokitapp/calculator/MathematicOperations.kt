package com.istekno.retrokitapp.calculator

import android.view.View
import android.widget.TextView

class MathematicOperations {

    private val listNumber = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".")
    private val listOperator = arrayOf(".", "(", ")", "/", "*", "-", "+", "%", "^", "sqrt(")

    private fun appendCalc(tvCalculate: TextView, tvResult: TextView, string: String, isClear: Boolean) {
        if (isClear) {
            if (!tvResult.text.isEmpty() && !listNumber.contains(string)) {
                tvCalculate.text = tvResult.text
                tvResult.text = ""
            } else {
                tvCalculate.text = ""
                tvResult.text = ""
                tvCalculate.append(string)
            }
        } else {
            val listCalculate = tvCalculate.text.toList()
            if (listCalculate.isNotEmpty()) {
                val str = listCalculate[listCalculate.size - 1].toString()
                if (str == string) {
                    if (!listOperator.contains(string)) tvCalculate.append(string)
                } else if (str != string) {
                    if (!listOperator.contains(str) || listNumber.contains(string)) tvCalculate.append(string)
                }
            } else {
                tvCalculate.append(string)
            }
        }
    }

    private fun actionGeneral(listButton: IntArray, listStr: Array<String>, view: View, tvCalculate: TextView, tvResult: TextView) {
        val index = listButton.indexOf(view.id)
        val str = listStr[index]
        val isClear = str == ""

        if (tvResult.text.isEmpty()) {
            appendCalc(tvCalculate, tvResult, str, isClear)
        } else if (!tvResult.text.isEmpty() && listNumber.contains(str)) {
            appendCalc(tvCalculate, tvResult, str, true)
        } else {
            appendCalc(tvCalculate, tvResult, "", true)
            appendCalc(tvCalculate, tvResult, str, isClear)
        }
    }

    fun getActionGeneral(listButton: IntArray, listStr: Array<String>, view: View, tvCalculate: TextView, tvResult: TextView) = actionGeneral(listButton, listStr, view, tvCalculate, tvResult)
}