package com.kanchan.androidsysteminternalworking

import android.app.Application
import com.kanchan.androidsysteminternalworking.notifications.NotificationBuilder

class AndroidApp: Application() {
    override fun onCreate() {
        super.onCreate()
        NotificationBuilder.createNotificationChannel(context = applicationContext)
    }
}
