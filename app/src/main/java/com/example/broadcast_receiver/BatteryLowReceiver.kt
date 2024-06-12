package com.example.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryLowReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Battery Low!", Toast.LENGTH_SHORT).show()
    }
    // onReceive Method: This method is called when the broadcast is received.
    // In this method, we display a toast message indicating that the battery is low.
}