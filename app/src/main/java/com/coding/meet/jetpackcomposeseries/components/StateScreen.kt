package com.coding.meet.jetpackcomposeseries.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Modifier
import com.coding.meet.jetpackcomposeseries.MainViewModel

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:12 am
 */

@Composable
fun StateScreen() {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Log.d("TAG", "initial Composition")
    Button(onClick = {
        count++
        Log.d("TAG", count.toString())
    }) {
        Log.d("TAG", "re-Composition")
        Text(text = "$count Click")
    }
}

@Composable
fun IncScreen(mainViewModel: MainViewModel) {
    Button(onClick = {
        mainViewModel.inc()
    }) {
        Text(text = "${mainViewModel.count} Inc")
    }
}

@Composable
fun DecScreen(mainViewModel: MainViewModel) {
    Button(onClick = {
        mainViewModel.dec()
    }) {
        Text(text = "${mainViewModel.count} Dec")
    }
}


@Composable
fun MutableStateListExample() {
    val items = remember {
       mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        items.forEach{item ->
            Text(text = item)

        }

        Button(onClick = {
            items.add("New Item ${items.size + 1}")

        }) {
            Text(text = "Add Item")
        }
    }

}