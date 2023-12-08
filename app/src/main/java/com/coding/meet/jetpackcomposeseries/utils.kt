package com.coding.meet.jetpackcomposeseries

import androidx.lifecycle.*

/**
 * @author Coding Meet
 * Created 08-12-2023 at 04:32 pm
 */

inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = f() as T
    }