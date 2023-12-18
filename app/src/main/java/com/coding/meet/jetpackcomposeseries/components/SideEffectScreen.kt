package com.coding.meet.jetpackcomposeseries.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

/**
 * @author Coding Meet
 * Created 18-12-2023 at 12:37 pm
 */


@Composable
fun WithoutSideEffectExample() {
    var counter by remember {
        mutableStateOf(0)
    }
    val context = LocalContext.current

    Toast.makeText(context, "Hello world", Toast.LENGTH_SHORT).show()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            counter++

        }) {
            Text(text = "Click Here")
        }
        Text(text = "$counter")
    }
}

@Composable
fun LaunchEffectExample() {
    var counter by remember {
        mutableStateOf(0)
    }

    var isInitialized by remember {
        mutableStateOf(false)
    }

    var apiCaling by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current


//    LaunchedEffect(key1 = Unit) {
//        Toast.makeText(context, "Hello world", Toast.LENGTH_SHORT).show()
//        // api calling
//        // viewmodel.getApi()
//    }


//    LaunchedEffect(key1 = isInitialized) {
//        if (!isInitialized) {
//            Toast.makeText(context, "Hello world", Toast.LENGTH_SHORT).show()
//            // api calling
//            // viewmodel.getApi()
//            isInitialized = true
//        }
//    }


//    LaunchedEffect(key1 = counter) {
//        Toast.makeText(context, "Hello world", Toast.LENGTH_SHORT).show()
//
//        // api calling
//        // viewmodel.getApi()
//    }


    LaunchedEffect(key1 = apiCaling) {
        Toast.makeText(context, "Api Caling", Toast.LENGTH_SHORT).show()
        // api calling
        // viewmodel.getApi()

    }

    // not code here
    // viewmodel.getApi()


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            apiCaling = !apiCaling

        }) {
            Text(text = "Click Here")
        }
        Text(text = "$counter")
    }
}


@Composable
fun CoroutineScopeExample() {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
           scope.launch{
                try{
                    Log.d("tag","api 1 Start")
                    delay(10000)
                    Log.d("tag","api 1 End")
                }catch (e:CancellationException){
                    Log.d("tag","api 1 cancel")
                }
            }

        }) {
            Text(text = "Api 1 call")
        }
        Button(onClick = {
            scope.launch{
                try{
                    Log.d("tag","api 2 Start")
                    delay(5000)
                    Log.d("tag","api 2 End")
                }catch (e:CancellationException){
                    Log.d("tag","api 2 cancel")
                }
            }
        }) {
            Text(text = "Api 2 call")
        }
        Button(onClick = {
            scope.coroutineContext.cancelChildren()
        }) {
            Text(text = "All Api cancel")
        }
    }
}

@Composable
fun TimerScreen() {
    var counter by remember {
        mutableStateOf(0)
    }

    DisposableEffect(Unit){

        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            while (true){
                delay(1000)
                counter  += 1
                Log.d("tag","$counter")
            }
        }

        onDispose {
            job.cancel()
            Log.d("tag","Job End")
            Log.d("tag","$counter")
        }
    }
    Text(text = "$counter",
        fontSize = 30.sp)

}

@Composable
fun RuntimeScreen() {
    var isVisible by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (isVisible){
            TimerScreen()
        }

        Button(onClick = {
            isVisible = !isVisible
        }) {
            Text(text = "show / Hide Timer")
        }
    }
}

@Composable
fun WithUseSideEffectExample() {
    var counter by remember {
        mutableStateOf(0)
    }

    SideEffect {
        Log.d("tag",counter.toString())
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            counter++

        }) {
            Text(text = "Click Here")
        }
        Text(text = "$counter")
    }
}