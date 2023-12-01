package com.coding.meet.jetpackcomposeseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import com.coding.meet.jetpackcomposeseries.ui.theme.JetpackComposeSeriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSeriesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AllTypeOfButton()
                }
            }
        }
    }
}


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

        Text(text ="$firstNameState $lastNameState")
    }
}

@Composable
fun AllTypeOfButton(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { }
        , modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .padding(8.dp)) {
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
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)) {
            Text(text = "Hello World")
        }
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)) {
            Text(text = "Hello" , color = Color.Black)
            Text(text = " World", color = Color.Yellow)
        }

        Button(onClick = { /*TODO*/ }) {
            Image(imageVector =
                Icons.Default.ShoppingCart, contentDescription = "Cwnd",
                colorFilter =  ColorFilter.tint(Color.White)
            )
            Text(text = "Add To Cart" , modifier = Modifier.padding(start= 8.dp))
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
        Button(onClick = { /*TODO*/ }, shape = CutCornerShape(10.dp),
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
          border = BorderStroke(2.dp,Color.Black)
        ) {
            Text(text = "Hello World")
        }
    }

}
