package com.example.firstsession

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        Log.d("Main2Activity", "onCreate")
      //  println("onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d("Main2Activity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Main2Activity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Main2Activity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Main2Activity", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Main2Activity", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main2Activity", "onDestroy")
    }
}