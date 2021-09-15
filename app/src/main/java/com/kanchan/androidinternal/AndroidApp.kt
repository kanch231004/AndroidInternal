package com.kanchan.androidinternal

import android.app.Application
import com.kanchan.androidinternal.notifications.NotificationBuilder

class AndroidApp: Application() {
    override fun onCreate() {
        super.onCreate()
        NotificationBuilder.createNotificationChannel(context = applicationContext)
    }
}
