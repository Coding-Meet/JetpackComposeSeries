package com.coding.meet.jetpackcomposeseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import com.coding.meet.jetpackcomposeseries.components.SurfaceScreen
import com.coding.meet.jetpackcomposeseries.ui.theme.JetpackComposeSeriesTheme
import com.coding.meet.jetpackcomposeseries.ui.theme.*


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

                Column(modifier = Modifier.fillMaxSize().background(
                    if (darkTheme) { Color.Black } else { Color.Yellow}
                )) {

                    SurfaceScreen()
                    Switch(
                        modifier = Modifier.scale(1.5f),
                        checked = darkTheme, onCheckedChange = {
                            darkTheme = it
                        },
                        thumbContent = {
                            Icon(
                                imageVector = if (darkTheme) Icons.Filled.Check else Icons.Filled.Close,
                                tint = if (darkTheme) greenColor else Color.White,
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
                    Text(text = if (darkTheme) "On" else "OFF")

                }
            }
        }
    }
}
