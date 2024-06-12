package com.example.services

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstsession.R

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val intent = Intent(this, MyBackgroundService::class.java)
        startService(intent)

        val intent2 = Intent(this, MyForegroundService::class.java)
        stopService(intent)

//        val intent3 = Intent(this, MyBoundService::class.java)
//        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
// calling bindService() when another component wants to bind with the service (such as to perform RPC)
    }
}