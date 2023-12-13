package com.coding.meet.jetpackcomposeseries.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.coding.meet.jetpackcomposeseries.ui.theme.greenColor

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:03 am
 */

@Composable
fun FabScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Click", Toast.LENGTH_LONG).show()
            },
            shape = CutCornerShape(20.dp),
            containerColor = greenColor,
            contentColor = Color.Black,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 10.dp
            ),
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        SmallFloatingActionButton(
            onClick = {
                Toast.makeText(context, "Click", Toast.LENGTH_LONG).show()

            },
            containerColor = greenColor,
            contentColor = Color.Black,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 10.dp
            ),
        ) {
            Icon(Icons.Filled.Add, "Small floating action button.")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        LargeFloatingActionButton(
            onClick = {
                Toast.makeText(context, "Click", Toast.LENGTH_LONG).show()

            },
            shape = CircleShape,
            containerColor = greenColor,
            contentColor = Color.Black,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 10.dp
            ),
        ) {
            Icon(Icons.Filled.Add, "Large floating action button")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        ExtendedFloatingActionButton(
            onClick = {
                Toast.makeText(context, "Click", Toast.LENGTH_LONG).show()

            },
            expanded = true,
            containerColor = greenColor,
            contentColor = Color.Black,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 10.dp
            ),
            icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
            text = { Text(text = "Extended FAB") },
        )
    }
}