package com.example.services

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log

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
    /**
     *- intent: Intent?
     * This parameter holds the Intent that was used to start the service.
     * It contains any data passed by the caller when starting the service.
     *
     *- flags: Int
     * The flags parameter provides additional information about how the service was started. There are a few possible flag values that can be passed in this parameter:
     *
     *  START_FLAG_REDELIVERY:
     *  Indicates that the service is being restarted after being killed, and the last Intent is being redelivered. This is used in conjunction with the START_REDELIVER_INTENT return value.
     *  Example: Useful when the service processes tasks that should be continued after a restart.
     *
     *  START_FLAG_RETRY:
     *  Indicates that the service is being restarted after being killed, but it is not receiving the original Intent (common with START_STICKY).
     *  Example: The service was killed due to system resource constraints and is being restarted with a new, clean state.
     *
     *  0 (No flags):
     *  This indicates that the service was started normally without any special conditions.
     *
     *  You typically don’t need to handle these flags manually unless your service behavior needs to change depending on whether it's being restarted or not.
     *
     *
     * **/
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Perform background work here
        return START_NOT_STICKY
    }
    /**
     * These are return values from the onStartCommand() method that tell the system how
     * the service should behave if it is killed by the system (due to low memory, for instance).
     * Here’s a breakdown of the different options:
     *
     * START_STICKY:
     *
     * The service will be restarted automatically if it is killed by the system, even if there are no pending intents to deliver.
     * The service is restarted in the same state as it was when killed, but no Intent data will be redelivered unless new intents come in later.
     * This is typically used for services that are supposed to run indefinitely,
     * like music players, ongoing tasks, or anything that needs to continue running in the background.
     *
     * START_NOT_STICKY:
     *
     * The service will not be restarted if it is killed by the system.
     * This is suitable for tasks that don’t need to resume if the service is stopped or killed.
     * The service will only be restarted if a new explicit startService() call is made.
     * Used for short-lived tasks that are okay if they get killed and don’t need to restart.
     *
     * START_REDELIVER_INTENT:
     *
     * Similar to START_STICKY, but with an important difference: if the service is restarted,
     * the last intent that was sent to onStartCommand() is redelivered.
     * This is useful for services that are handling individual tasks based on the intent
     * they receive, so when restarted, they can continue processing the same intent.
     * **/

    // you must provide an interface that clients use to communicate with the service by returning an IBinder.
    // You must always implement this method; however, if you don't want to allow binding,
    // you should return null when We don't support binding in this service
    override fun onBind(intent: Intent?): IBinder? {
        return null  // We don't support binding in this service
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