package com.example.intents.explicit

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.MainActivity3
import com.example.firstsession.Main2Activity
import com.example.firstsession.R

class MainActivity : AppCompatActivity() {

    // Starting an activity for result
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val returnedIntent: Intent? = result.data
            // Handle the Intent result here
            val resultText = returnedIntent?.getStringExtra("RESULT_KEY")
            //  textViewResult.text = resultText
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating an explicit intent to start SecondActivity
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("EXTRA_MESSAGE", "Hello, SecondActivity!")
        startActivity(intent)

        // Creating an implicit intent to share text content
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hello, world!")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
        // Declare a general action such as ACTION_SEND.
        //Use Intent.createChooser for a chooser dialog.





        val intent3 = Intent(this, SecondActivity::class.java)
        startForResult.launch(intent)

    }
}