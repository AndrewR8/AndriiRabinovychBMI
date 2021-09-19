package com.example.andriirabinovychbmi.ui.results

import androidx.lifecycle.ViewModel

class ResultsBmiViewModel : ViewModel() {
    private val thresholdUnderWeight = 17.0F
    private val thresholdOverWeight = 25.0F

    fun condition(bmi: Float?): String {
        var conditionString = ""

        when (bmi){
            (bmi?.coerceAtMost(thresholdUnderWeight)) -> conditionString = " Underweight"
            (bmi?.coerceIn(thresholdUnderWeight, thresholdOverWeight)) -> conditionString = " Normal"
            (bmi?.coerceAtLeast(thresholdOverWeight)) -> conditionString = " Overweight"
        }

        return conditionString
    }

}