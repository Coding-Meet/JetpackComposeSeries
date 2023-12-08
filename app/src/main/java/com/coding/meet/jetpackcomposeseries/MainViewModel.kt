package com.coding.meet.jetpackcomposeseries

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

/**
 * @author Coding Meet
 * Created 08-12-2023 at 04:17 pm
 */

class MainViewModel(name :String) : ViewModel(){
    var count by mutableStateOf(0)
        private set

    fun inc(){
        count++
    }

    fun dec(){
        count--
    }
}