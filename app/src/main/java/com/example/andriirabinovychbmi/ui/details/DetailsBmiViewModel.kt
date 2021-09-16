package com.example.andriirabinovychbmi.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsBmiViewModel : ViewModel() {

    private var name = ""
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

    val bmi = weight.value?.div(height.value!!.times(2))

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

    fun onCalculateClicked() {
    }
}
