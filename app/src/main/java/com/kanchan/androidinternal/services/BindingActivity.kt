package com.kanchan.androidinternal.services

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity

class BindingActivity: AppCompatActivity() {

    private lateinit var mService: LocalService
    private var mBound: Boolean = false


    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
           val binder = service as LocalService.LocalBinder
            mService = binder.getService()
            mService.communicateWithService()
            mBound  = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mBound  = false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService()
    }

    private fun startService() {
        val intent = Intent(this, LocalService::class.java)
        bindService(intent, serviceConnection, -1);
    }

    override fun onDestroy() {
        super.onDestroy()
        mBound  = false
    }
}
