package com.magicworld.jetpackcomposeinstagram.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorAnimationSimple() {


    Spacer(modifier = Modifier.size(200.dp))

    var firstColor by rememberSaveable { mutableStateOf(false) }
    var showBox by rememberSaveable { mutableStateOf(true) }

    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Green,
        animationSpec = tween(2000),
        finishedListener = { showBox = false }
    )
    if (showBox) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor }) {

        }
    }
}

@Composable
fun SizeAnimation() {

    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(500),
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable { smallSize = !smallSize }) {

    }
}