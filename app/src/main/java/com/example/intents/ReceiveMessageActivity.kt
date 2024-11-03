package com.example.intents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstsession.R
import com.example.firstsession.databinding.ActivityRecieveMessageBinding
import com.example.firstsession.databinding.ActivityRecyclerViewBinding

class ReceiveMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecieveMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecieveMessageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Get the Intent that started this activity and extract the string
        if (intent?.action == Intent.ACTION_SEND) {
            if ("text/plain" == intent.type) {
                val receivedText = intent.getStringExtra(Intent.EXTRA_TEXT) ?: ""
                binding.tvRecievedMessage.text = receivedText
            }
        }
    }
}