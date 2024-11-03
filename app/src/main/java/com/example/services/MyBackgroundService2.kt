package com.example.services

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import android.widget.Toast

class MyBackgroundService2 : Service() {

    private val handler = Handler(Looper.getMainLooper())
    private val task = object : Runnable {
        override fun run() {
            // Perform your background task here
            Log.d("MyService", "Service is running...")
            Toast.makeText(this@MyBackgroundService2, "Background Task Running", Toast.LENGTH_SHORT).show()
            // Schedule the next execution
            handler.postDelayed(this, 10000) // 10 seconds
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "Service Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "Service Started")
        handler.post(task)
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop the periodic task
        handler.removeCallbacks(task)
        Log.d("MyService", "Service Destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? {
        // We don't provide binding, so return null
        return null
    }
}
// The Handler and Runnable setup in the MyBackgroundService class ensures that the background task
// is run periodically every 10 seconds. The handler.post(task) method starts the initial task,
// and the handler.postDelayed(this, 10000) within the task schedules the next execution.

// Use Services for long-running tasks that need to run in the background continuously, especially when immediate user interaction or foreground execution is required.
//Use WorkManager for tasks that need guaranteed execution, deferrable tasks, or tasks with complex constraints.

/**
 * In Android, the lifecycle of a Service is different from that of an Activity.
 * Here's why it's better to start a task in onStartCommand() rather than onCreate():
 *
 * onCreate() is only called once when the service is first created. If your service is started multiple times using startService()
 * (with the same or different intents), onCreate() won’t be called again. This is useful for initializing resources,
 * but it’s not ideal for starting tasks because:
 *
 * If the service is restarted after being killed, onCreate() may not be called again (depending on the service's restart behavior), but onStartCommand() will be.
 * Tasks started in onCreate() won’t handle subsequent service restarts or new intents properly.
 * onStartCommand() is called every time startService() is called. This is the recommended place to start tasks because:
 *
 * It allows the service to handle each new intent and any restart after the service is killed.
 * It can receive and process data passed through the Intent, so tasks can be managed dynamically based on different input.
 * It is called after onCreate() when the service is first created, and on subsequent requests to start the service.
 * **/