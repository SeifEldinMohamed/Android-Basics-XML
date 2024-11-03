package com.example.services

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstsession.R
import com.example.firstsession.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {
    lateinit var binding: ActivityServiceBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityServiceBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

//        val intent2 = Intent(this, MyForegroundService::class.java)
//        stopService(intent)

//        val intent3 = Intent(this, MyBoundService::class.java)
//        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
// calling bindService() when another component wants to bind with the service (such as to perform RPC)

        val intent = Intent(this, MyBackgroundService::class.java)
        binding.btnStartService.setOnClickListener {
        val intent2 = Intent(applicationContext, MyBackgroundService2::class.java)
 //           startService(intent)
            startService(intent2)
        }

        binding.btnStopService.setOnClickListener {
            val intent2 = Intent(applicationContext, MyBackgroundService2::class.java)
 //           stopService(intent)
            stopService(intent2)
        }
    }
}
/**
 * Since Android 8.0 (Oreo), there are additional restrictions on background services. Developers need to use:
 *
 * JobScheduler: For deferrable, scheduled tasks.
 * WorkManager: For guaranteed background work, with support for constraints like network status and battery level.
 * **/