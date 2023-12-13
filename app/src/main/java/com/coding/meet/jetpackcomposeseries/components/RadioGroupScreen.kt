package com.coding.meet.jetpackcomposeseries.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.coding.meet.jetpackcomposeseries.R
import com.coding.meet.jetpackcomposeseries.ui.theme.greenColor

/**
 * @author Coding Meet
 * Created 13-12-2023 at 04:27 pm
 */

@Composable
fun RadioGroupScreen() {
    val optionList = listOf(
        "Male", "Female", "Other"
    )

    var selectedIndex by remember {
        mutableStateOf(0)
    }
    val disableItemPos = -1
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .selectableGroup()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        optionList.forEachIndexed { index, label ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        role = Role.RadioButton,
                        enabled = disableItemPos != index
                    )
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    modifier = Modifier.padding(end = 16.dp),
                    selected = selectedIndex == index,
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = greenColor,
                        unselectedColor = Color.DarkGray,
                        disabledSelectedColor = Color.LightGray,
                        disabledUnselectedColor = Color.LightGray
                    ),
                    enabled = disableItemPos != index
                )
                Icon(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(
                        id = if (selectedIndex == index) R.drawable.check_circle
                        else R.drawable.unchecked_circle
                    ), contentDescription = null,
                    tint =
                    if (disableItemPos != index) {
                        if (selectedIndex == index) greenColor else Color.DarkGray
                    } else {
                        Color.LightGray
                    }
                )
                Text(
                    text = label,
                    color = if (disableItemPos != index) Color.DarkGray else Color.LightGray
                )
            }
        }
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    optionList[selectedIndex],
                    Toast.LENGTH_LONG
                ).show()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Submit")
        }
    }
} 