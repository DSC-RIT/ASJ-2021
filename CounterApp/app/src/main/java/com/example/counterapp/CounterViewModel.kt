package com.example.counterapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
//    private var _counter: Int = 0
//    val counter: Int
//        get() = _counter
//
//    fun increaseCounter() {
//        _counter++
//    }

    private val _counter: MutableLiveData<Int> = MutableLiveData(0)
    val counter: LiveData<Int>
        get() = _counter

    fun increaseCounter() {
        _counter.value = _counter.value?.plus(1)
    }
}