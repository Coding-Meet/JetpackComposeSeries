package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author Coding Meet
 * Created 27-12-2023 at 02:34 pm
 */

@Composable
fun IndeterminatePIScreen() {
    var isShowing by remember {
        mutableStateOf(false)
    }
    if (isShowing) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            color = Color.Blue,
            trackColor = Color.LightGray
        )
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp),
            color = Color.Blue
        )
    }
    Button(onClick = { isShowing = !isShowing }) {
        Text(
            text = if (isShowing) {
                "visible"
            } else {
                "Not Visible"
            }
        )
    }
}

@Composable
fun DeterminatePIScreen() {
    var isShowing by remember {
        mutableStateOf(false)
    }
    var currentProgress by remember {
        mutableStateOf(0f)
    }
    val scope = rememberCoroutineScope()

    if (isShowing) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            color = Color.Blue,
            trackColor = Color.LightGray,
            progress = currentProgress
        )
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp),
            color = Color.Blue,
            progress = currentProgress
        )
    }
    Button(onClick = {
        isShowing = true
        scope.launch {
            for (i in 1.. 100){
                currentProgress = i.toFloat() / 100
                delay(100)
            }
            isShowing = false
        }
    }, enabled = !isShowing ) {
        Text(
            text = "Start Loading"
        )
    }
}