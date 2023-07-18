package com.example.uptodo.ui.screens.main

import android.util.Log
import com.example.uptodo.R
import com.example.uptodo.ui.screens.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun initialize() {

    }

    private fun showLog(message: Any){
        Log.i("RRR", message.toString())
    }

}