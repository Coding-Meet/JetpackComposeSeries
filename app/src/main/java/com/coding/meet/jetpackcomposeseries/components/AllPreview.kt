package com.coding.meet.jetpackcomposeseries.components

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author Coding Meet
 * Created 26-12-2023 at 04:23 pm
 */

@Preview(name="night", group = "element",fontScale = 1.5f, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "light", group = "",fontScale = 1.5f, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dw", group = "",fontScale = 1.5f, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "daw", group = "",fontScale = 1.5f, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "ad", group = "",fontScale = 1.5f, uiMode = Configuration.UI_MODE_NIGHT_NO)
annotation class AllPreview()
