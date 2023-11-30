package com.example.styling

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val inputText = MutableLiveData<String>()
    val enable = MutableLiveData(false)
    val acceptableDigits = MutableLiveData<String>()

    val mediatorInputText = MediatorLiveData<String>()

    init {
        mediatorInputText.addSource(inputText) {
            if (it.isNotEmpty() /* && FuelPointData.phoneShouldStartWithZero */) {
                acceptableDigits.value = "0123456789"
            } else {
                acceptableDigits.value = "123456789"
            }

            enable.value = true /*it.length == FuelPointData.phoneNumberLengthServerConfig*/
        }
    }
}