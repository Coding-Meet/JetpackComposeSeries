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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.coding.meet.jetpackcomposeseries.R
import com.coding.meet.jetpackcomposeseries.ui.theme.*

/**
 * @author Coding Meet
 * Created 14-12-2023 at 01:37 pm
 */


@Composable
fun MultipleCheckBoxScreen() {
    val optionList = listOf(
        "Android", "Kotlin", "Java", "Jetpack compose", "XML", "Gradle"
    )

    val disableItemPos = listOf<Int>()
    var checkItemPos by remember {
        mutableStateOf(listOf<Int>())
    }

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
                        selected = checkItemPos.contains(index),
                        onClick = {
                            checkItemPos = if (checkItemPos.contains(index)) {
                                checkItemPos - index
                            } else {
                                checkItemPos + index
                            }
                        },
                        role = Role.Checkbox,
                        enabled = index !in disableItemPos
                    )
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    modifier = Modifier.padding(end = 16.dp),
                    checked = checkItemPos.contains(index),
                    onCheckedChange = null,
//                    onCheckedChange = {
//                        checkItemPos = if (it) {
//                            checkItemPos + index
//                        } else {
//                            checkItemPos - index
//                        }
//                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = greenColor,
                        uncheckedColor = Color.DarkGray,
                        checkmarkColor = Color.DarkGray,
                        disabledIndeterminateColor = Color.LightGray,
                        disabledUncheckedColor = Color.LightGray,
                        disabledCheckedColor = Color.LightGray
                    ),
                    enabled = index !in disableItemPos
                )
//                Icon(
//                    modifier = Modifier.padding(end = 16.dp),
//                    painter =
//                    painterResource(
//                        id =
//                        if (checkItemPos.contains(index)) {
//                            R.drawable.check_box
//                        } else {
//                            R.drawable.check_box_outline
//                        }
//                    ), contentDescription = null,
//                    tint = if (index !in disableItemPos) {
//                        if (checkItemPos.contains(index)) greenColor else Color.DarkGray
//                    } else {
//                        Color.LightGray
//                    }
//                )
                Text(
                    text = label,
                    fontWeight = if (index !in disableItemPos) FontWeight.Bold else FontWeight.Normal,
                    color = if (index !in disableItemPos) Color.Black else Color.LightGray,
                )
            }
        }
        Button(
            onClick = {
                val selectedOption = checkItemPos.map { optionList[it] }
                Toast.makeText(
                    context,
                    selectedOption.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Submit")
        }

    }
}


@Composable
fun TriStateCheckBoxScreen() {
    val optionList = listOf(
        "Android", "Kotlin", "Java", "Jetpack compose", "XML", "Gradle"
    )

    val disableItemPos = listOf<Int>()
    var checkItemPos by remember {
        mutableStateOf(listOf<Int>())
    }
    var triStateChecked by remember {
        mutableStateOf(ToggleableState.Indeterminate)
    }


    val context = LocalContext.current
    Column(
        modifier = Modifier
            .selectableGroup()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectable(
                    selected = triStateChecked == ToggleableState.On,
                    onClick = {
                        if (triStateChecked == ToggleableState.Indeterminate) {
                            triStateChecked = ToggleableState.On
                            checkItemPos = (optionList.indices).toList()
                        } else {
                            triStateChecked = ToggleableState.Indeterminate
                            checkItemPos = emptyList()
                        }
                    },
                    role = Role.Checkbox,
                )
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TriStateCheckbox(
                modifier = Modifier.padding(horizontal = 16.dp),
                state = triStateChecked,
                onClick = null,
//                onClick = {
//                    if (triStateChecked == ToggleableState.Indeterminate) {
//                        triStateChecked = ToggleableState.On
//                        checkItemPos = (optionList.indices).toList()
//                    } else {
//                        triStateChecked = ToggleableState.Indeterminate
//                        checkItemPos = emptyList()
//                    }
//                },
                colors = CheckboxDefaults.colors(
                    checkedColor = if (triStateChecked == ToggleableState.Indeterminate)
                        Color.LightGray else greenColor,
                    uncheckedColor = Color.DarkGray,
                    checkmarkColor = Color.DarkGray,
                    disabledIndeterminateColor = Color.LightGray,
                    disabledUncheckedColor = Color.LightGray,
                    disabledCheckedColor = Color.LightGray
                ),
            )
            Text(
                text = "Select All",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

        }

        optionList.forEachIndexed { index, label ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = checkItemPos.contains(index),
                        onClick = {
                            checkItemPos = if (checkItemPos.contains(index)) {
                                checkItemPos - index
                            } else {
                                checkItemPos + index
                            }
                            triStateChecked = ToggleableState.Indeterminate
                        },
                        role = Role.Checkbox,
                        enabled = index !in disableItemPos
                    )
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    modifier = Modifier.padding(end = 16.dp),
                    checked = index !in disableItemPos && checkItemPos.contains(index),
                    onCheckedChange = null,
//                    onCheckedChange = {
//                        checkItemPos = if (it) {
//                            checkItemPos + index
//                        } else {
//                            checkItemPos - index
//                        }
//                      triStateChecked = ToggleableState.Indeterminate
//                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = greenColor,
                        uncheckedColor = Color.DarkGray,
                        checkmarkColor = Color.DarkGray,
                        disabledIndeterminateColor = Color.LightGray,
                        disabledUncheckedColor = Color.LightGray,
                        disabledCheckedColor = Color.LightGray
                    ),
                    enabled = index !in disableItemPos
                )
//                Icon(
//                    modifier = Modifier.padding(end = 16.dp),
//                    painter =
//                    painterResource(
//                        id =
//                        if (index !in disableItemPos &&  checkItemPos.contains(index)) {
//                            R.drawable.check_box
//                        } else {
//                            R.drawable.check_box_outline
//                        }
//                    ), contentDescription = null,
//                    tint = if (index !in disableItemPos) {
//                        if (checkItemPos.contains(index)) greenColor else Color.DarkGray
//                    } else {
//                        Color.LightGray
//                    }
//                )
                Text(
                    text = label,
                    fontWeight = if (index !in disableItemPos) FontWeight.Bold else FontWeight.Normal,
                    color = if (index !in disableItemPos) Color.Black else Color.LightGray,
                )
            }
        }
        Button(
            onClick = {
                val selectedOption = checkItemPos.filter { it !in disableItemPos }.map { optionList[it] }
                Toast.makeText(
                    context,
                    selectedOption.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Submit")
        }

    }
}