package com.clearsky77.jetpackviewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS, MINUS
}

class MyNumberViewModel : ViewModel() {

    companion object {
        const val TAG: String = "태그"
    }
    private val _currentValue = MutableLiveData<Int>()

    val currentValue: MutableLiveData<Int>
        get() = _currentValue

    // 초기값 설정
   init {
        Log.d(TAG,"MyNumberViewModel - 생성자 호출")
        _currentValue.value = 0 // Mutable이라서 변경이 가능하다.
    }

    fun updateValue(actionType: ActionType, input: Int){
        when(actionType){
            ActionType.PLUS ->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS ->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }

    fun resetValue(){
        _currentValue.value = 0
    }
}