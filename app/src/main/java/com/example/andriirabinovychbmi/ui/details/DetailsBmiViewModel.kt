package com.example.andriirabinovychbmi.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class DetailsBmiViewModel : ViewModel() {

    var name = "friend"
    val minValue = 1
    val maxValue = 300
    val genderList = arrayOf(
        ("Male"),
        ("Female")
    )

    private val _weight = MutableLiveData(minValue)
    val weight: LiveData<Int> = _weight

    private val _height = MutableLiveData(minValue)
    val height: LiveData<Int> = _height

    private val _gender = MutableLiveData(genderList.first())
    val gender: MutableLiveData<String> = _gender

    private val _bmi = MutableLiveData(minValue.toFloat())
    val bmi: MutableLiveData<Float> = _bmi

    private val _calculateBtnEnabled = MutableLiveData(true)
    val calculateBtnEnabled: LiveData<Boolean> = _calculateBtnEnabled

    fun onNameEdited(name: String) {
        this.name = name
    }

    fun onWeightSelected(value: Int) {
        _weight.value = value
    }

    fun onHeightSelected(value: Int) {
        _height.value = value
    }

    fun onGenderSelected(gender: String) {
        _gender.value = gender
    }

    fun onCalculateClicked(){
        val bmi = weight.value?.toFloat()?.div(height.value!!.times( height.value!!))!!.times(10000)
        _bmi.value = bmi
    }
}
