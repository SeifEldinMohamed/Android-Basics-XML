package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.firstsession.R

class MyForegroundService : Service() {
    // Override onBind for bound services, return null for unbound services.
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setContentTitle("Foreground Service")
            .setContentText("Service is running")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        // Use startForeground to start the service with a notification.
        startForeground(1, notification)
        return START_NOT_STICKY
    }
}