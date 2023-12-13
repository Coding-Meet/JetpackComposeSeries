package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:08 am
 */

@Composable
fun BoxScreen() {
    Box(
        modifier = Modifier.background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .width(300.dp)
                .height(200.dp)
                .border(2.dp, Color.Black)
        ) {
            Text(text = "Hello World", modifier = Modifier.align(Alignment.TopStart))
            Text(text = "Coding Meet", modifier = Modifier.align(Alignment.Center))
            Text(text = "Hello World", modifier = Modifier.align(Alignment.BottomEnd))
        }

    }
}