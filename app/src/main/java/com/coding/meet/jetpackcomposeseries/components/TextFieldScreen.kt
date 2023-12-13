package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:06 am
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen() {
    var firstNameState by remember { mutableStateOf("") }
    var lastNameState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = firstNameState,
            onValueChange = { firstNameState = it },
            label = { Text("First Name") }
        )
        OutlinedTextField(
            value = lastNameState,
            onValueChange = { lastNameState = it },
            label = { Text("Last Name") }
        )

        Text(text = "$firstNameState $lastNameState")
    }
}