package com.coding.meet.jetpackcomposeseries.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

/**
 * @author Coding Meet
 * Created 19-12-2023 at 03:41 pm
 */


@Composable
fun RememberUpdateStateExample() {
    var buttonColors by remember {
        mutableStateOf("unknown")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            buttonColors = "Red"
        }) {
            Text(text = "Red")
        }
        Button(onClick = {
            buttonColors = "Black"
        }) {
            Text(text = "Black")
        }
        PassState(buttonColors)
    }
}

@Composable
fun PassState(buttonColors: String) {
    Log.d("tag recompo", buttonColors)
    val buttonColorUpdated by rememberUpdatedState(newValue = buttonColors)
    LaunchedEffect(key1 = Unit) {
        delay(10000)
        Log.d("tag", "timer ended")
        Log.d("tag buttonColors", buttonColors)
        Log.d("tag buttonColorUpdated", buttonColorUpdated)
    }
}

@Composable
fun ProduceStateExample() {

    val counter by produceState(initialValue = 0) {
        while (true) {
            delay(1000)
            value += 1
        }
    }

    val userDataState: State<UserData?> = produceState<UserData?>(initialValue = null) {
        val result = fetchDataFromApi()
        value = result
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$counter")
        userDataState.value?.let {
            Text(text = "name => ${it.name}")
            Text(text = "age => ${it.age}")
        } ?: Text("Loading")
    }


}

suspend fun fetchDataFromApi(): UserData {
    return withContext(Dispatchers.IO) {
        delay(5000)
        UserData("Coding Meet", 21)
    }
}

data class UserData(val name: String, val age: Int)


@Composable
fun DerivedStateOfExample() {
    var counter by remember {
        mutableStateOf(0)
    }
    val evenOdd by remember {
        derivedStateOf {
            if (counter % 2 == 0) "even"
            else "old"
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$counter")
        Text(text = "count is $evenOdd")
        Button(onClick = {
            counter++
        }) {
            Text(text = "Counter")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DerivedStateOfExample2() {
    var numberOne by remember {
        mutableStateOf(0)
    }
    var numberTwo by remember {
        mutableStateOf(0)
    }
    val sum by remember {
        derivedStateOf {
            "$numberOne + $numberTwo = ${numberOne + numberTwo}"
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = "$numberOne", onValueChange = {
            numberOne = it.toIntOrNull() ?: 0
        })
        TextField(value = "$numberTwo", onValueChange = {
            numberTwo = it.toIntOrNull() ?: 0
        })
        Text(text = sum)
    }
}

@Composable
fun SnapShotFlowExample() {
    var counter by remember {
        mutableStateOf(1)
    }
    val squareList = remember {
        mutableStateListOf<Int>()
    }

    LaunchedEffect(key1 = Unit) {
        snapshotFlow {
            counter
        }.map { it }
            .distinctUntilChanged { old, new ->
                Log.d("tag old value", old.toString())
                Log.d("tag new value", new.toString())
                old == new
            }.collect() {
                squareList.add(it)
                Log.d("tag collect", it.toString())
            }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$counter")
        Button(onClick = {
            counter++
        }) {
            Text(text = "Counter")
        }
        Button(onClick = {
            counter = 10
        }) {
            Text(text = "10")
        }
        Text(text = squareList.toList().toString())
    }
}