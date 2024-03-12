package com.kanchan.androidinternal

import android.app.Application
import android.util.Log
import com.kanchan.androidinternal.notifications.NotificationBuilder

class AndroidApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("Internal", "onCreate: Android app")
        NotificationBuilder.createNotificationChannel(context = applicationContext)
    }
}
