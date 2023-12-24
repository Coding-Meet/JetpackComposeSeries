package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:11 am
 */

// 0.1f  => 10%
// 0.5f  => 50%
// 1.0f => 100%

@Composable
fun ModifierScreen() {
    Box(
        modifier = Modifier
            .size(200.dp, 200.dp)
            .border(2.dp, Color.White, RoundedCornerShape(10))
            .clip(RoundedCornerShape(10))
            .background(Color.Blue)
    )
}


@Composable
fun EqualWidthInRow() {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello World",
            modifier = Modifier
                .weight(1f)
                .background(Color.LightGray)
                .border(2.dp, Color.Black),
            fontSize = 20.sp, textAlign = TextAlign.Center
        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .weight(1f)
                .background(Color.Magenta)
                .border(2.dp, Color.Black),
            fontSize = 20.sp, textAlign = TextAlign.Center

        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .weight(1f)
                .background(Color.Yellow)
                .border(2.dp, Color.Black),
            fontSize = 20.sp, textAlign = TextAlign.Center
        )
    }
}

@Composable
fun EqualWidthInColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Hello World",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.LightGray)
                .border(2.dp, Color.Black)
                .wrapContentSize(Alignment.Center),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)
                .border(2.dp, Color.Black)
                .wrapContentSize(Alignment.Center),
            fontSize = 20.sp
        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow)
                .border(2.dp, Color.Black)
                .wrapContentSize(Alignment.Center),
            fontSize = 20.sp
        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green)
                .border(2.dp, Color.Black)
                .wrapContentSize(Alignment.Center),
            fontSize = 20.sp
        )
    }
}


@Composable
fun BoxModifierScreen(modifier: Modifier) {
    Box(modifier = modifier

    ) {

        Text(text = "Hello world", fontSize = 32.sp, modifier = Modifier.align(Alignment.Center))
    }

}