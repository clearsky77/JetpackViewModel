package com.clearsky77.jetpackviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var myNumberViewModel: MyNumberViewModel

    companion object {
        const val TAG: String = "태그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)
        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "MainActivity - currentValue: $it")
            txtNum.text = it.toString()
        })
        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "두번째로 등록한 옵져버 $it")
            txtNum.text = it.toString()
        })
        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "세번째로 등록한 옵져버 $it")
            txtNum.text = it.toString()
        })

        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnReset.setOnClickListener(this)
        btnTest.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        val userInput: Int = edtNum.text.toString().toInt()

        when (view) {
            btnPlus -> myNumberViewModel.updateValue(ActionType.PLUS, userInput)
            btnMinus -> myNumberViewModel.updateValue(ActionType.MINUS, userInput)
            btnReset -> myNumberViewModel.resetValue()
            btnTest -> txtCopy.text = txtNum.text.toString()
        }
    }
}