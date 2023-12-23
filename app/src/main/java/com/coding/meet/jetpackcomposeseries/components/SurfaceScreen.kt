package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @author Coding Meet
 * Created 22-12-2023 at 04:18 pm
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SurfaceScreen() {
    var isSelected by remember {
        mutableStateOf(false)
    }
    var isChecked by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(text = "Coding Meet")
    }
    Spacer(modifier = Modifier.padding(10.dp))
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        shape = CutCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Black),
        shadowElevation = 10.dp,
        color = MaterialTheme.colorScheme.background,
    ) {
        Text(text = "Coding Meet")
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        shape = CutCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Black),
        shadowElevation = 10.dp,
        color = MaterialTheme.colorScheme.background,
        onClick = {

        }
    ) {
        Text(text = "Coding Meet")
    }
    Surface(
        selected = isSelected,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        shape = CutCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Black),
        shadowElevation = 10.dp,
        color = MaterialTheme.colorScheme.background,
        onClick = {
            isSelected = !isSelected
        }
    ) {
        Text(text = "Coding Meet $isSelected")
    }

    Surface(
        checked = isChecked,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        shape = CutCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Black),
        shadowElevation = 10.dp,
        color = MaterialTheme.colorScheme.background,
       onCheckedChange = {
           isChecked = it
       }
    ) {
        Text(text = "Coding Meet $isChecked")
    }

}
