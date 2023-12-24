package com.coding.meet.jetpackcomposeseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.coding.meet.jetpackcomposeseries.components.BoxModifierScreen
import com.coding.meet.jetpackcomposeseries.ui.theme.JetpackComposeSeriesTheme
import com.coding.meet.jetpackcomposeseries.ui.theme.customBackgroundWithBorder


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


                Column(modifier = Modifier.fillMaxSize()) {
                    BoxModifierScreen(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .customBackgroundWithBorder(backGroundColor = Color.LightGray)

                    )
                    BoxModifierScreen(
                       Modifier
                           .fillMaxWidth()
                           .weight(1f)
                           .customBackgroundWithBorder(isBorder = false, backGroundColor = Color.Yellow)
                    )
                }
            }
        }
    }
}
