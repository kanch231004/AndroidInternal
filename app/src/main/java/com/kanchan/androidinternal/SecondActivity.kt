package com.kanchan.androidinternal

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kanchan.androidinternal.databinding.FragmentSecondBinding
import com.kanchan.androidinternal.notifications.NotificationBuilder
import com.kanchan.backstack.ThirdActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : FragmentSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(binding.root.context, ThirdActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(binding.root.context, 0 , intent,
            PendingIntent.FLAG_IMMUTABLE)
        binding.btnSecond.setOnClickListener {
            NotificationBuilder.showNotification(
                NotificationBuilder.notificationBuilder(
                context = binding.root.context,
                intent = pendingIntent,
                icon = R.drawable.ic_launcher_background
            ), context = binding.root.context)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, FirstFragment())
                .addToBackStack("true").commit()
        }
        Log.d(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d(
            TAG,
            "onCreate() called with: savedInstanceState = $savedInstanceState, persistentState = $persistentState"
        )
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    companion object {
        val TAG = "SecondActivity"
    }
}
