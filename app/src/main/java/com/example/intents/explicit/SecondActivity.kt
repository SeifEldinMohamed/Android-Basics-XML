package com.example.intents.explicit

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstsession.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val name = intent.getStringExtra("KEY_NAME")


       // buttonReturnResult.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("RESULT_KEY", "Result from Second Activity")
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
      //  }

    }
}