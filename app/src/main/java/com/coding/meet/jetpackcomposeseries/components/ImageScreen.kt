package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coding.meet.jetpackcomposeseries.R

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:08 am
 */

@Composable
fun ImageScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "hello",
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(10))
                .background(Color.Black)
                .border(5.dp, Color.Gray, RoundedCornerShape(10)),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_add_shopping_cart_24),
            tint = Color.Red,
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(100.dp)) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}