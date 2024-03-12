package com.kanchan.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

const val TAG = "MainActivityVM"
class TestCoroutineVM: ViewModel() {
    var job: Job? = null
    fun makeLongCall() {
        viewModelScope.launch {
            var i = 0
            while (i++ < 10) {
                delay(1000)
                Log.d("MainActivityVM", "makeLongCall VM scope: ${this.coroutineContext.toString()}")
            }
        }
    }

    fun makeLongCallWithCustomScope() {
        job = CoroutineScope(Dispatchers.Main).launch {
            var i = 0
            while (i++ < 10) {
                delay(1000)
                Log.d("MainActivityVM", "makeLongCall customScope: ${this.coroutineContext.toString()}")
            }
        }
    }

    fun checkRunBlocking() {
        Log.d(TAG, "checkRunBlocking: outside")
        viewModelScope.launch {
            Log.d(TAG, "checkRunBlocking: delay start 1000")
            delay(1000)
            Log.d(TAG, "checkRunBlocking: delay end 1000")
        }
        Log.d(TAG, "checkRunBlocking: outside end")
    }

    suspend fun testCoroutineLifeCycle() {
        Log.d(TAG, "testCoroutineLifeCycle: Testing coroutine ended")
        delay(10000)
        Log.d(TAG, "testCoroutineLifeCycle: Testing coroutine ended")
    }


     fun testCoroutineCancel() {
         job = viewModelScope.launch {
            for ( i in 1..10) {
                delay(1000)
                Log.d(TAG, "testCoroutineCancel: print $i")
            }
        }
    }

    fun cancelJob() = runBlocking {
        try {
            delay(4000)
            job?.cancel()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("MainActivityVM", "onCleared: called")
        job?.cancel()
    }

    suspend fun testCombineAndZip() {

        val flowInt = flowOf<Int>(2,3,4).onEach { delay(200) }
       val flowString = flowOf<String> ("a", "b", "c", "d").onEach { delay(500) }

        flowInt.combine(flowString) {
            a, b -> "$a -> $b" }
            .collect {
                value -> println(value)
            }
    }
}