package com.coding.meet.jetpackcomposeseries.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

/**
 * @author Coding Meet
 * Created 01-01-2024 at 01:58 pm
 */


@Composable
fun LazyVerticalGridScreen() {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        columns = GridCells.Adaptive(200.dp)) {
        items(100) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Yellow, shape = RoundedCornerShape(4.dp))
                    .border(width = 2.dp, color =Color.Black, shape = RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$index", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
        }
    }

}

@Composable
fun LazyHorizontalGridScreen() {
    LazyHorizontalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        rows = GridCells.Fixed(3)) {
        items(100) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(100.dp)
                    .background(Color.Yellow, shape = RoundedCornerShape(4.dp))
                    .border(width = 2.dp, color =Color.Black, shape = RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$index", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
        }
    }

}

data class ListItemDataModel(
    val size : Dp,
    val color : Color
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalStaggeredGridScreen() {
    val sizeColorList = (1..100).map {
        ListItemDataModel(
            size = Random.nextInt(100,300).dp,
            color = Color(
                Random.nextInt(255),
                Random.nextInt(255),
                Random.nextInt(255),
                alpha = 255
            )
        )

    }


    LazyVerticalStaggeredGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        columns = StaggeredGridCells.Adaptive(80.dp)) {
        itemsIndexed(sizeColorList) { index,item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(item.size)
                    .background(item.color, shape = RoundedCornerShape(4.dp))
                    .border(width = 2.dp, color =Color.Black, shape = RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$index", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyHorizontalStaggeredGridScreen() {
    val sizeColorList = (1..100).map {
        ListItemDataModel(
            size = Random.nextInt(100,300).dp,
            color = Color(
                Random.nextInt(255),
                Random.nextInt(255),
                Random.nextInt(255),
                alpha = 255
            )
        )

    }


    LazyHorizontalStaggeredGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        horizontalItemSpacing = 8.dp,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        rows = StaggeredGridCells.Adaptive(80.dp)) {
        itemsIndexed(sizeColorList) { index,item ->
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(item.size)
                    .background(item.color, shape = RoundedCornerShape(4.dp))
                    .border(width = 2.dp, color =Color.Black, shape = RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$index", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
        }
    }

}