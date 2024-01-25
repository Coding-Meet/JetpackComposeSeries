package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.coding.meet.jetpackcomposeseries.R

/**
 * @author Coding Meet
 * Created 23-01-2024 at 12:58 pm
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogScreen(
    onDismissRequest: () -> Unit,
    onConfirmationRequest: () -> Unit,
) {
    AlertDialog(
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
        ),

        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirmationRequest()
            }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismissRequest()
            }) {
                Text(text = "Cancel")
            }
        },
        icon = {
            Icon(imageVector = Icons.Default.Info, contentDescription = "info")
        },
        title = {
            Text(text = "Alert Dialog")
        },
        text = {
            Text(text = "This is Alert Dialog Description")
        }
    )
}

@Composable
fun CustomDialogScreen(
    onDismissRequest: () -> Unit,
    onConfirmationRequest: () -> Unit,
) {
    Dialog(onDismissRequest = {
        onDismissRequest()
    },  properties = DialogProperties(
        dismissOnBackPress = false,
        dismissOnClickOutside = false,
        usePlatformDefaultWidth = false
    ),
        ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth().wrapContentHeight().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier.height(160.dp)
                )
                Text(
                    text = "This is Custom Dialog Description",
                    modifier = Modifier.padding(16.dp)
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    TextButton(onClick = {
                        onDismissRequest()
                    }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = {
                        onConfirmationRequest()
                    }) {
                        Text(text = "Confirm")
                    }
                }
            }
        }
    }
}