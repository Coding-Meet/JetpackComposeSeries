package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.coding.meet.jetpackcomposeseries.SharePreferenceManager

/**
 * @author Coding Meet
 * Created 26-01-2024 at 02:52 pm
 */


@Composable
fun SharedPreferencesScreen() {
    val context = LocalContext.current
    val sharePreferenceManager = remember {
        SharePreferenceManager(context)
    }
    var nameState by remember { mutableStateOf(
        sharePreferenceManager.name
    ) }
    var ageState by remember { mutableStateOf(
        sharePreferenceManager.age.toString()
    ) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = nameState,
            onValueChange = { nameState = it },
            label = { Text("Enter Name") }
        )
        TextField(
            value = ageState,
            onValueChange = { ageState = it },
            label = { Text("Enter Age") }
        )
        Button(onClick = {
            sharePreferenceManager.name = nameState
            sharePreferenceManager.age = ageState.toIntOrNull() ?: 0
        }) {
            Text(text = "Set")
        }
        Button(onClick = {
            nameState = sharePreferenceManager.name
            ageState = sharePreferenceManager.age.toString()
        }) {
            Text(text = "Get")
        }
        Button(onClick = {
            nameState = ""
            ageState = ""

//            sharePreferenceManager.name = ""
//            sharePreferenceManager.age = 0
//
            sharePreferenceManager.clear()
        }) {
            Text(text = "Clear")
        }
    }
}