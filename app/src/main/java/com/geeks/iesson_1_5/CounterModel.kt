package com.geeks.iesson_1_5

class CounterModel {

    private var count = 0

    fun inc(){
        count++
    }
    fun dec(){
        count--
    }
    fun getResult() = count
}