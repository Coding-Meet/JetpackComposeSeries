package com.coding.meet.jetpackcomposeseries.components

import android.content.res.Configuration
import android.text.DynamicLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import com.coding.meet.jetpackcomposeseries.ui.theme.JetpackComposeSeriesTheme

/**
 * @author Coding Meet
 * Created 26-12-2023 at 04:02 pm
 */


@AllPreview
@Composable
fun PreviewScreen() {
 Button(onClick = { /*TODO*/ },
  ) {
  Text(text = "Coding Meet")
 }
}
@Preview(
 showSystemUi = true,
 showBackground = true,wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
 backgroundColor = 0xFFF3A813,
 device = "id:pixel_2"
)
@Composable()
fun DynamicColorScreen() {
 JetpackComposeSeriesTheme{
  PreviewScreen()
 }
}

@Preview(group = "element", fontScale = 2.5f)
@Composable
fun SquareComposablePreview() {
 Box(Modifier.background(Color.Yellow)) {
  Text("Hello World")
 }
}
