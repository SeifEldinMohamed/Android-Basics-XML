package com.example.intents.implecit

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstsession.R

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        // Creating an implicit intent to share text content
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hello, world!")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))

    }

   // Intent(Intent.ACTION_VIEW, Uri.parse("http://www.example.com"))

   // intent.type = "image/*“

   //  intent.putExtra("key", "value")




}