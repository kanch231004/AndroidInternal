package com.kanchan.androidinternal

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.kanchan.androidinternal.databinding.ActivityMainBinding
import com.kanchan.coroutines.TestCoroutineVM
import com.kanchan.coroutines.TestCoroutineActivity
import com.kanchan.kotlin.TestKotlin
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var mainVM: TestCoroutineVM
    companion object {
        val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainVM = ViewModelProvider(this).get(TestCoroutineVM::class.java)

        binding.fab.setOnClickListener { view ->
           // startActivity(Intent(this,TestCoroutineActivity::class.java))
            mainVM.cancelJob()
        }

        testCoroutines()
        testKotlin()
        Log.d(TAG, "onCreate() called")
    }

    private fun testCoroutines() {
//      mainVM.makeLongCallWithCustomScope()
//      mainVM.makeLongCall()
  //      mainVM.checkRunBlocking()
        mainVM.testCoroutineCancel()

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

    override fun onRestart() {
        Log.d(TAG, "onRestart: called")
        super.onRestart()
    }

    override fun isChangingConfigurations(): Boolean {
        Log.d(TAG, "isChangingConfigurations: called")
        return super.isChangingConfigurations()
    }

    override fun reportFullyDrawn() {
        super.reportFullyDrawn()
    }

    private fun testKotlin() {
        TestKotlin.testHashCodes(TestKotlin.Person1(), TestKotlin.Person2())
        TestKotlin.testObjects(TestKotlin.Person1(), TestKotlin.Person2())
        TestKotlin.testSameClass(TestKotlin.Person1(), TestKotlin.Person1("Kanchan", "Pal"))
        TestKotlin.testSameClass(TestKotlin.Person1(), TestKotlin.Person1("Kanchan", "Pal2"))
    }
}
