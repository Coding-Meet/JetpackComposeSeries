package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * @author Coding Meet
 * Created 19-01-2024 at 01:38 pm
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModelBottomSheetScreen() {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    val scope = rememberCoroutineScope()

    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.Yellow,
            sheetState = sheetState,
            onDismissRequest = {
                showBottomSheet = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Button(onClick = {
                scope.launch {
                    sheetState.hide()
                }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet = false
                    }
                }

            }) {
                Text(text = "Hide Bottom Sheet")
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = {
            showBottomSheet = true
        }) {
            Text(text = "Show Bottom Sheet")

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardBottomSheetScreen() {
    val scope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        sheetPeekHeight = 0.dp,
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
        Button(onClick = {
            scope.launch {
                bottomSheetScaffoldState.bottomSheetState.partialExpand()
            }

        }) {
            Text(text = "Hide Bottom Sheet")
        }
    }) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = {
                scope.launch {
                    bottomSheetScaffoldState.bottomSheetState.expand()
                }
            }) {
                Text(text = "Show Bottom Sheet")

            }
        }
    }
}