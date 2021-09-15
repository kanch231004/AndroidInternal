package com.kanchan.androidsysteminternalworking.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat


class NotificationBuilder {
	companion object {
		private lateinit var notificationManager: NotificationManager
		fun notificationBuilder(context: Context, intent: PendingIntent, icon: Int) : Notification {
			return NotificationCompat.Builder(context, "123").setSmallIcon(icon)
				.setContentTitle("Notification Title")
				.setContentText("Description")
				.setContentIntent(intent)
				.setPriority(NotificationCompat.PRIORITY_DEFAULT)
				.setAutoCancel(true).build()
		}

		fun showNotification(message : Notification, context: Context) {
			notificationManager.notify(123, message)
		}

		fun createNotificationChannel(context: Context) {
			// Create the NotificationChannel, but only on API 26+ because
			// the NotificationChannel class is new and not in the support library
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				val name = "Water name"
				val descriptionText = "Description Text"
				val importance = NotificationManager.IMPORTANCE_DEFAULT
				val channel = NotificationChannel("123", name, importance).apply {
					description = descriptionText
				}
				// Register the channel with the system
				notificationManager  = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
				notificationManager.createNotificationChannel(channel)
			}
		}
	}
}
