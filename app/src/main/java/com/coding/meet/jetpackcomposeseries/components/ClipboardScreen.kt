package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString

/**
 * @author Coding Meet
 * Created 29-01-2024 at 03:26 pm
 */

@Composable
fun ClipboardScreen() {
    val clipboardManager = LocalClipboardManager.current
    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(value = text, onValueChange ={
            text = it
        } )
        Button(onClick = {
            clipboardManager.setText(AnnotatedString("Coding Meet"))
        }) {
            Text(text = "Copy")
        }
        Button(onClick = {
            clipboardManager.getText()?.text?.let {
                text = it
            }
        }) {
            Text(text = "Get")
        }
    }
}