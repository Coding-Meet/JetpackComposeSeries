package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.coding.meet.jetpackcomposeseries.models.Student
import com.coding.meet.jetpackcomposeseries.ui.theme.*
import java.util.UUID

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:14 am
 */


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
