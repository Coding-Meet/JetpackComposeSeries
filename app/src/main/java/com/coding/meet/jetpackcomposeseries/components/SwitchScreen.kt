package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import com.coding.meet.jetpackcomposeseries.ui.theme.checkedThumbColor
import com.coding.meet.jetpackcomposeseries.ui.theme.checkedTrackColor
import com.coding.meet.jetpackcomposeseries.ui.theme.greenColor
import com.coding.meet.jetpackcomposeseries.ui.theme.uncheckedThumbColor
import com.coding.meet.jetpackcomposeseries.ui.theme.uncheckedTrackColor

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:04 am
 */

@Composable
fun SwitchScreen() {
    var checked by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Switch(
            modifier = Modifier.scale(1.5f),
            checked = checked, onCheckedChange = {
                checked = it
            },
            thumbContent = {
                Icon(
                    imageVector = if (checked) Icons.Filled.Check else Icons.Filled.Close,
                    tint = if (checked) greenColor else Color.White,
                    contentDescription = ""
                )
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = checkedThumbColor,
                checkedTrackColor = checkedTrackColor,
                uncheckedThumbColor = uncheckedThumbColor,
                uncheckedTrackColor = uncheckedTrackColor,
                uncheckedBorderColor = uncheckedThumbColor
            )
        )
        Text(text = if (checked) "On" else "OFF")
    }
}

