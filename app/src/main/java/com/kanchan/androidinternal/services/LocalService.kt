package com.kanchan.androidinternal.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class LocalService  : Service(){
    private var toggle : Boolean = false
    private val binder = LocalBinder()

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    inner class LocalBinder : Binder() {
       public fun getService(): LocalService = this@LocalService
    }

    public fun communicateWithService() {
        toggle != toggle
    }
}
