package com.coding.meet.jetpackcomposeseries

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.staggeredgrid.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import com.coding.meet.jetpackcomposeseries.ui.theme.*
import java.util.UUID


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSeriesTheme {
//                var count by rememberSaveable {
//                    mutableStateOf(0)
//                }

                // without parameter
//                val mainViewModel by viewModels<MainViewModel>()

                // with parameter
//                val mainViewModel : MainViewModel = viewModel(
//                    factory = viewModelFactory {
//                        MainViewModel("Meet")
//                    }
//                )
//                Row{
//                    IncScreen(mainViewModel)
//                    DecScreen(mainViewModel)
//                }

                SwitchScreen()
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

        Text(text = "$firstNameState $lastNameState")
    }
}

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

@OptIn(ExperimentalTextApi::class)
@Composable
fun TextScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello World")
        Text(text = stringResource(id = R.string.hello_world))
        Text(text = "Hello World", color = Color.Red)
        Text(
            text = "Hello World", color = Color.Red, fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Hello World", color = Color.Red,
            textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Hello World", color = Color.Red,
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = "Hello World", color = Color.Blue,
            fontFamily = FontFamily(
                Font(R.font.roboto_bold)
            ), fontSize = 30.sp
        )
        Text(
            text = "Hello World", style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Blue, Color.LightGray, Color.Yellow)
                )
            ),
            fontFamily = FontFamily(
                Font(R.font.roboto_bold)
            ), fontSize = 30.sp
        )
        Text(
            text = "Hello World",
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Blue,
                    offset = Offset(5.0f, 30.0f),
                    blurRadius = 3f
                )
            )
        )

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                ) {
                    append("H")
                }
                append("ello ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                ) {
                    append("W")
                }
                append("orld")

            },
            fontSize = 30.sp
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Blue, Color.LightGray, Color.Yellow)
                        )
                    )
                ) {
                    append("Hello ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                ) {
                    append("W")
                }
                append("orld")

            },
            fontSize = 30.sp
        )
        Text(
            text = "Hello World Hello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello World",
            maxLines = 1, overflow = TextOverflow.Ellipsis
        )

        ClickableText(text = AnnotatedString("Click Me"), onClick = {
            Log.d("message", "Hello World")
        })
    }
}


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

@Composable
fun RowScreen() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello World",
            modifier = Modifier
                .background(Color.LightGray)
                .border(2.dp, Color.Black),
            fontSize = 20.sp
        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .background(Color.Magenta)
                .border(2.dp, Color.Black),
            fontSize = 20.sp
        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .background(Color.Yellow)
                .border(2.dp, Color.Black),
            fontSize = 20.sp
        )
    }
}

@Composable
fun ColumnScreen() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello World",
            modifier = Modifier
                .background(Color.LightGray)
                .border(2.dp, Color.Black),
            fontSize = 20.sp
        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .background(Color.Magenta)
                .border(2.dp, Color.Black),
            fontSize = 20.sp
        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .background(Color.Yellow)
                .border(2.dp, Color.Black),
            fontSize = 20.sp
        )
        Text(
            text = "Hello World",
            modifier = Modifier
                .background(Color.Green)
                .border(2.dp, Color.Black),
            fontSize = 20.sp
        )
    }
}

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
fun StateScreen() {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Log.d("TAG", "initial Composition")
    Button(onClick = {
        count++
        Log.d("TAG", count.toString())
    }) {
        Log.d("TAG", "re-Composition")
        Text(text = "$count Click")
    }
}

@Composable
fun IncScreen(mainViewModel: MainViewModel) {
    Button(onClick = {
        mainViewModel.inc()
    }) {
        Text(text = "${mainViewModel.count} Inc")
    }
}

@Composable
fun DecScreen(mainViewModel: MainViewModel) {
    Button(onClick = {
        mainViewModel.dec()
    }) {
        Text(text = "${mainViewModel.count} Dec")
    }
}

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

@Composable
fun LazyScreen() {
    val studentList = mutableListOf(
        Student(UUID.randomUUID().toString(), "Meet", 21, "male"),
        Student(UUID.randomUUID().toString(), "Ankit", 20, "male"),
        Student(UUID.randomUUID().toString(), "Bhumi", 21, "female"),
        Student(UUID.randomUUID().toString(), "Raj", 23, "male"),
        Student(UUID.randomUUID().toString(), "Abhishek", 26, "male"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
    ) {
        LazyRowScreen()
        LazyColumnScreen()
    }
}

@Composable
fun LazyColumnScreen() {
    val studentList = mutableListOf(
        Student(UUID.randomUUID().toString(), "Meet", 21, "male"),
        Student(UUID.randomUUID().toString(), "Ankit", 20, "male"),
        Student(UUID.randomUUID().toString(), "Bhumi", 21, "female"),
        Student(UUID.randomUUID().toString(), "Raj", 23, "male"),
        Student(UUID.randomUUID().toString(), "Abhishek", 26, "male"),
    )
    val studentList1 = mutableListOf(
        Student(UUID.randomUUID().toString(), "Meet", 21, "male"),
        Student(UUID.randomUUID().toString(), "Ankit", 20, "male"),
        Student(UUID.randomUUID().toString(), "Bhumi", 21, "female"),
        Student(UUID.randomUUID().toString(), "Raj", 23, "male"),
        Student(UUID.randomUUID().toString(), "Abhishek", 26, "male"),
    )
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        item {
            studentList.forEachIndexed { index, student ->
                Text(text = "$student")
            }
        }
        item {
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = greenColor
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                ),
            ) {
                Text(
                    text = "First Item",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    textAlign = TextAlign.Center
                )
            }
        }

        items(5) { index ->
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Yellow
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                ),
            ) {
                Text(
                    text = "Item: $index",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    textAlign = TextAlign.Center
                )
            }
        }
        item {
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = greenColor
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                ),
            ) {
                Text(
                    text = "End Item",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(studentList.size,
            key = { index ->
                studentList[index].id
            }
        ) { index ->
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                ),
            ) {
                Text(
                    text = "${studentList[index].name}",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    textAlign = TextAlign.Center
                )
            }
        }
        itemsIndexed(studentList1,
            key = { index, student ->
                student.id
            }
        ) { index, student ->
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Red
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                ),
            ) {
                Text(
                    text = "${student.name}",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun LazyRowScreen() {
    val studentList = mutableListOf(
        Student(UUID.randomUUID().toString(), "Meet", 21, "male"),
        Student(UUID.randomUUID().toString(), "Ankit", 20, "male"),
        Student(UUID.randomUUID().toString(), "Bhumi", 21, "female"),
        Student(UUID.randomUUID().toString(), "Bhumi", 21, "female"),
        Student(UUID.randomUUID().toString(), "Raj", 23, "male"),
        Student(UUID.randomUUID().toString(), "Abhishek", 26, "male"),
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        itemsIndexed(studentList,
            key = { index, student ->
                student.id
            }
        ) { index, student ->
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Red
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                ),
            ) {
                Text(
                    text = "${student.name}",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize()
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

data class Student(
    val id: String,
    val name: String,
    val age: Int,
    val gender: String,
)

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