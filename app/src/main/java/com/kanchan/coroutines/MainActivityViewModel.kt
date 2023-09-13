package com.kanchan.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG = "MainActivityVM"
class MainActivityViewModel: ViewModel() {
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

    override fun onCleared() {
        super.onCleared()
        Log.d("MainActivityVM", "onCleared: called")
        job?.cancel()
    }
}