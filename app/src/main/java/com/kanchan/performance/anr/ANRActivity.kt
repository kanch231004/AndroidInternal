package com.kanchan.performance.anr

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kanchan.androidinternal.R

class ANRActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anr)
        var count = 1
        val textView = findViewById<TextView>(R.id.tvANR)

        for ( i in 1..10000) {
            textView.setText(count++)
        }
    }
}