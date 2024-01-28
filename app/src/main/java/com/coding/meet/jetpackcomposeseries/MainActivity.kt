package com.coding.meet.jetpackcomposeseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.jetpackcomposeseries.components.*
import com.coding.meet.jetpackcomposeseries.ui.theme.JetpackComposeSeriesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme by remember {
                mutableStateOf(false)
            }
            JetpackComposeSeriesTheme(darkTheme) {
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

//                Column(modifier = Modifier.fillMaxSize().background(
//                    if (darkTheme) { Color.Black } else { Color.Yellow}
//                )) {
//
//                    SurfaceScreen()
//                    Switch(
//                        modifier = Modifier.scale(1.5f),
//                        checked = darkTheme, onCheckedChange = {
//                            darkTheme = it
//                        },
//                        thumbContent = {
//                            Icon(
//                                imageVector = if (darkTheme) Icons.Filled.Check else Icons.Filled.Close,
//                                tint = if (darkTheme) greenColor else Color.White,
//                                contentDescription = ""
//                            )
//                        },
//                        colors = SwitchDefaults.colors(
//                            checkedThumbColor = checkedThumbColor,
//                            checkedTrackColor = checkedTrackColor,
//                            uncheckedThumbColor = uncheckedThumbColor,
//                            uncheckedTrackColor = uncheckedTrackColor,
//                            uncheckedBorderColor = uncheckedThumbColor
//                        )
//                    )
//                    Text(text = if (darkTheme) "On" else "OFF")
//
//                }


//                Column(modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally) {
//                    BoxModifierScreen(
//                        Modifier
//                            .fillMaxWidth()
//                            .weight(1f)
//                            .customBackgroundWithBorder(backGroundColor = Color.LightGray)
//
//                    )
//                    BoxModifierScreen(
//                       Modifier
//                           .fillMaxWidth()
//                           .weight(1f)
//                           .customBackgroundWithBorder(isBorder = false, backGroundColor = Color.Yellow)
//                    )

//                    StarAnimation()
//                    LoadingAnimation()
//                }

//                var isShowAlertDialog by remember {
//                    mutableStateOf(false)
//                }
//                var isShowCustomDialog by remember {
//                    mutableStateOf(false)
//                }
//                Column {
//                    Button(onClick = {
//                        isShowAlertDialog = true
//                    }) {
//                        Text(text = "Alert Dialog Show")
//                    }
//                    Button(onClick = {
//                        isShowCustomDialog = true
//                    }) {
//                        Text(text = "Custom Dialog Show")
//                    }
//                }
//                if (isShowAlertDialog) {
//                    AlertDialogScreen(
//                        onDismissRequest = {
//                            isShowAlertDialog = false
//                        },
//                        onConfirmationRequest = {
//                            isShowAlertDialog = false
//                        }
//                    )
//                } else if (isShowCustomDialog){
//                    CustomDialogScreen(
//                        onDismissRequest = {
//                            isShowCustomDialog = false
//                        },
//                        onConfirmationRequest = {
//                            isShowCustomDialog = false
//                        }
//                    )
//                }

                EncryptedSharedPreferencesScreen()
            }
        }
    }
}
