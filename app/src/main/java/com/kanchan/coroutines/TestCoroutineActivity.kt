package com.kanchan.coroutines

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestCoroutineActivity: AppCompatActivity() {
    private lateinit var mainVM: TestCoroutineVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val button = Button(this)
        mainVM = ViewModelProvider(this)[TestCoroutineVM::class.java]
        lifecycleScope.launch(Dispatchers.IO) {
            mainVM.testCombineAndZip()
        }
        button.setOnClickListener {
            Log.d(TAG, "testCoroutineLifeCycle: button clicked")
            finish()
        }

    }
}