package com.coding.meet.jetpackcomposeseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.coding.meet.jetpackcomposeseries.components.*
import com.coding.meet.jetpackcomposeseries.ui.theme.JetpackComposeSeriesTheme


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

                RadioGroupScreen()
            }
        }
    }
}
