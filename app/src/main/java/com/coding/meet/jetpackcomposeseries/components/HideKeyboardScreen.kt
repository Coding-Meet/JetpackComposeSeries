package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HideKeyboard() {
    val controller =
        LocalSoftwareKeyboardController.current
    Button(onClick = {
        controller?.hide()
    }) {
        Text(text = "Hide Keyboard")
    }
}

