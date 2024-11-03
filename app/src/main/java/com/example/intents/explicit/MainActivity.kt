package com.example.intents.explicit

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.MainActivity3
import com.example.firstsession.Main2Activity
import com.example.firstsession.R
import com.example.firstsession.databinding.ActivityMainBinding

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
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Creating an explicit intent to start SecondActivity
        binding.btnNavigate.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("username", "Seif")
                startActivity(intent)
            finish()

        }


        // Creating an implicit intent to share text content
        binding.btnShare.setOnClickListener {
            val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello Seif From our first app!")
                shareIntent.type = "text/plain"

            startActivity(Intent.createChooser(shareIntent, "Share With"))
//            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.BanqueMisr.MobileBanking&hl=en&gl=US"))
//            startActivity(webIntent)
        }
        //Use Intent.createChooser for a chooser dialog.
//


//
//        val intent3 = Intent(this, SecondActivity::class.java)
//        startForResult.launch(intent3)

    }
}