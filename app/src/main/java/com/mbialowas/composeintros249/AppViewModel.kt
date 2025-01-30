package com.mbialowas.composeintros249

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {

    var counter = mutableStateOf(10)
    private set // prevent modification from outside view model

    fun incrementCounter(){
        counter.value += 1000
    }
}
