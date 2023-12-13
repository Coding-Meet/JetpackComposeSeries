package com.coding.meet.jetpackcomposeseries.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.coding.meet.jetpackcomposeseries.R

/**
 * @author Coding Meet
 * Created 13-12-2023 at 11:07 am
 */

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
