package com.example.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstsession.R

class DynamicBroadcastRegisterActivity : AppCompatActivity() {
    private lateinit var batteryLowReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_broadcast_register)
        batteryLowReceiver = BatteryLowReceiver()

    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_LOW)
        registerReceiver(batteryLowReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(batteryLowReceiver)
    }
}