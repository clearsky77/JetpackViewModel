package com.clearsky77.jetpackviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myNumberViewModel: MyNumberViewModel

    companion object {
        private val TAG: String = "태그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myNumberViewModel = ViewModelProvider(this).get(myNumberViewModel::class.java)
        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "MainActivity - currentValue: $it")
            txtNum.text = it.toString()
        })

    }
}