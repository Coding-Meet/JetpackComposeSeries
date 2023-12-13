package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.coding.meet.jetpackcomposeseries.ui.theme.greenColor

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:05 am
 */

@Composable
fun CardScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp),
            shape = CutCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = greenColor
            )
        ) {
            Text(
                text = "Hello, world!",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(),
                textAlign = TextAlign.Center
            )
        }

        ElevatedCardExample()

        OutlinedCardExample()
    }
}

@Composable
fun ElevatedCardExample() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
        shape = CutCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = greenColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
    ) {
        Text(
            text = "Hello, world!",
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OutlinedCardExample() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = greenColor
        ),
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
    ) {
        Text(
            text = "Hello, world!",
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(),
            textAlign = TextAlign.Center
        )
    }
}