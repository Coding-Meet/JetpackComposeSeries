package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @author Coding Meet
 * Created 16-12-2023 at 12:21 pm
 */


@Composable
fun DividerScreen() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Divider(
            modifier = Modifier.size(width = 40.dp, height = 100.dp).padding(16.dp),
            color =  Color.Green,
            thickness = 2.dp
        )
        Divider(
            modifier = Modifier.padding(16.dp)
        )
        Divider(
            modifier = Modifier.padding(16.dp),
            color =  Color.Red

        )
        Divider(
            modifier = Modifier.padding(16.dp),
            color =  Color.Blue,
            thickness = 4.dp
        )
        Divider(
            modifier = Modifier.width(200.dp).padding(16.dp),
            color =  Color.Blue,
            thickness = 4.dp
        )
        Divider(
            modifier = Modifier.size(width = 40.dp, height = 100.dp).padding(16.dp),
            color =  Color.DarkGray,
            thickness = 2.dp
        )
        Divider(
            modifier = Modifier.fillMaxHeight().width(width = 40.dp).padding(16.dp),
            color =  Color.Blue,
            thickness = 2.dp
        )
    }
}