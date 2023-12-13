package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:06 am
 */

@Composable
fun AllTypeOfButton() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { }, modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .padding(8.dp)
        ) {
            Text(text = "Hello world", fontSize = 20.sp)
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Hello World")
        }
        ElevatedButton(onClick = { /*TODO*/ }) {
            Text(text = "Hello world")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Hello World")
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            )
        ) {
            Text(text = "Hello World")
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            )
        ) {
            Text(text = "Hello", color = Color.Black)
            Text(text = " World", color = Color.Yellow)
        }

        Button(onClick = { /*TODO*/ }) {
            Image(
                imageVector =
                Icons.Default.ShoppingCart, contentDescription = "Cwnd",
                colorFilter = ColorFilter.tint(Color.White)
            )
            Text(text = "Add To Cart", modifier = Modifier.padding(start = 8.dp))
        }

        Button(onClick = { /*TODO*/ }, shape = RectangleShape) {
            Text(text = "Hello World")
        }
        Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(10.dp)) {
            Text(text = "Hello World")
        }

        Button(onClick = { /*TODO*/ }, shape = CutCornerShape(10.dp)) {
            Text(text = "Hello World")
        }
        Button(
            onClick = { /*TODO*/ }, shape = CutCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            ),
            enabled = false
        ) {
            Text(text = "Hello World")
        }
        Button(
            onClick = { /*TODO*/ }, shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text(text = "Hello World")
        }
    }
}