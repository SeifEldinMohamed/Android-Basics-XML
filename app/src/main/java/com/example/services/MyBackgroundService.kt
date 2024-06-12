package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyBackgroundService : Service() {
    // he system invokes this method to perform one-time setup procedures when the service
    // is initially created (before it calls either onStartCommand() or onBind()).
    // If the service is already running, this method is not called.
    override fun onCreate() {
        super.onCreate()
    }
    //  the service is started and can run in the background indefinitely.
    //  If you implement this, it is your responsibility to stop the service when
    //  its work is complete by calling stopSelf() or stopService().
    //  If you only want to provide binding, you don't need to implement this method.
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Perform background work here
        return START_NOT_STICKY
    }

    // you must provide an interface that clients use to communicate with the service by returning an IBinder.
    // You must always implement this method; however, if you don't want to allow binding,
    // you should return null.
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    // The system invokes this method when the service is no longer used and is being destroyed.
    // Your service should implement this to clean up any resources such as threads, registered listeners, or receivers.
    override fun onDestroy() {
        super.onDestroy()
    }

}

// Background services are limited in Android 8.0+.
// Use JobIntentService or WorkManager for longer-running tasks.

// If a component calls bindService() to create the service and onStartCommand() is not called,
// the service runs only as long as the component is bound to it.
// After the service is unbound from all of its clients, the system destroys it.

// The Android system stops a service only when memory is low and it must recover system resources
// for the activity that has user focus. If the service is bound to an activity that has
// user focus, it's less likely to be killed; if the service is declared to run in the
// foreground, it's rarely killed. If the service is started and is long-running,
// the system lowers its position in the list of background tasks over time,
// and the service becomes highly susceptible to killing—if your service is started,
// you must design it to gracefully handle restarts by the system.
// If the system kills your service, it restarts it as soon as resources become available,
// but this also depends on the value that you return from onStartCommand().