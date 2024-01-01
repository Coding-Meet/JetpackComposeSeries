package com.coding.meet.jetpackcomposeseries.components

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseOutSine
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coding.meet.jetpackcomposeseries.ui.theme.greenColor

/**
 * @author Coding Meet
 * Created 28-12-2023 at 03:28 pm
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewExpendedScreen() {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    OutlinedCard(
        onClick = {
            isExpanded = !isExpanded
        },
        colors = CardDefaults.cardColors(
            containerColor = greenColor
        ),
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Coding Meet", fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
                IconButton(onClick = {
                    isExpanded = !isExpanded
                }) {
                    Icon(
                        imageVector = if (isExpanded) {
                            Icons.Default.KeyboardArrowDown
                        } else {
                            Icons.Default.KeyboardArrowUp
                        }, contentDescription = ""
                    )
                }

            }
            AnimatedVisibility(visible = isExpanded) {
                Text(
                    text = "Welcome to Coding Meet, your go-to channel for learning Android programming! My channel is designed to provide you with the latest tutorials, tips, and tricks for building Android apps using Kotlin and Java. Whether you're a beginner or an experienced developer, I've got you covered with step-by-step guides and in-depth explanations. Join our community of passionate developers and take your Android programming skills to the next level with Coding Meet!",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 10.dp),
                )
            }
        }

    }

}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationCounterScreen() {
    var count by remember { mutableStateOf(0) }

    AnimatedContent(
        targetState = count,
        transitionSpec = {
            // Compare the incoming number with the previous number.
            if (targetState > initialState) {
                // If the target number is larger, it slides up and fades in
                // while the initial (smaller) number slides up and fades out.
                slideInVertically { height -> height } + fadeIn() with
                        slideOutVertically { height -> -height } + fadeOut()
            } else {
                // If the target number is smaller, it slides down and fades in
                // while the initial number slides down and fades out.
                slideInVertically { height -> -height } + fadeIn() with
                        slideOutVertically { height -> height } + fadeOut()
            }.using(
                // Disable clipping since the faded slide-in/out should
                // be displayed out of bounds.
                SizeTransform(clip = false)
            )
        }, label = ""
    ) { targetCount ->
        // Make sure to use `targetCount`, not `count`.
        Text(
            text = "$targetCount",
            fontSize = 100.sp
        )
    }
    Button(onClick = { count++ }) {
        Text("Inc")
    }
    Button(onClick = { count-- }) {
        Text("Dec")
    }
}

@Preview(showSystemUi = true)
@Composable
fun AnimationPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

        AnimationCounterScreen()
    }
}

@Composable
fun AnimatedScreen() {
    var toggle by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    val color by animateColorAsState(
        targetValue = if (toggle) Color.Yellow else Color.Red,
        label = "background color",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        finishedListener = {
            Toast.makeText(context, "finished", Toast.LENGTH_LONG).show()
        }
    )
    Box(
        modifier = Modifier
            .size(300.dp)
            .padding(24.dp)
            .background(color)
    )

    Button(onClick = {
        toggle = !toggle
    }) {
        Text(text = "Animate")
    }
}

@Composable
fun TransitionScreen() {
    var toggle by remember {
        mutableStateOf(false)
    }

    val transition = updateTransition(targetState = toggle, label = "dw")

    val color by transition.animateColor(label = "") {
        if (it) Color.Yellow else Color.Red
    }
//    val size by transition.animateDp(label = "") {
//        if (it) 300.dp else 100.dp
//    }

    val heightDP by transition.animateDp(label = "") {
        if (it) 200.dp else 300.dp
    }
    val widthDP by transition.animateDp(label = "") {
        if (it) 100.dp else 200.dp
    }


    Box(
        modifier = Modifier
            .size(width = widthDP, height = heightDP)
            .padding(24.dp)
            .background(color)
    )

    Button(onClick = {
        toggle = !toggle
    }) {
        Text(text = "Animate")
    }
}

@Composable
fun StarAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val rotate by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 2000
                0f at 0
                360f at 2000
            }
        ), label = ""
    )
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Yellow,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Icon(
        imageVector = Icons.Default.Star, contentDescription = "",
        modifier = Modifier
            .size(300.dp)
            .rotate(rotate),
        tint = color
    )
}

@Composable
fun LoadingAnimation() {
    val circleColors = listOf(
        Color(0xFF5851D8),
        Color(0xFF833AB4),
        Color(0xFFC13584),
        Color(0xFFE1306C),
        Color(0xFFFD1D1D),
        Color(0xFFF56040),
        Color(0xFFF77737),
        Color(0xFFFCAF45),
        Color(0xFFFFDC80),
        Color(0xFF5851D8)
    )
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val rotate by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = EaseOutSine
            )
        ), label = ""
    )
    CircularProgressIndicator(
        modifier = Modifier
            .size(150.dp)
            .rotate(rotate)
            .border(
                width = 4.dp,
                brush = Brush.sweepGradient(circleColors),
                shape = CircleShape
            )
    )
    Spacer(modifier = Modifier.padding(10.dp))
    Box(modifier = Modifier
        .size(200.dp)
        .clip(CircleShape)
        .background(
            brush = Brush.sweepGradient(circleColors),
            shape = CircleShape
        )
        .rotate(rotate))
}