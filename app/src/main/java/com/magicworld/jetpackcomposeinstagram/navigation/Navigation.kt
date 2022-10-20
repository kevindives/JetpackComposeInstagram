package com.magicworld.jetpackcomposeinstagram

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.magicworld.jetpackcomposeinstagram.model.Routes.*

@Composable
fun MyScreen1(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize()
    ) {
        Text(
            text = "pantalla uno",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Screen2.route) })
    }
}

@Composable
fun MyScreen2(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .fillMaxSize()
    ) {
        Text(
            text = "pantalla dos",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Screen3.route) })
    }
}

@Composable
fun MyScreen3(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize()
    ) {
        Text(
            text = "pantalla tres",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Screen4.createRoute(54)) })
    }
}

@Composable
fun MyScreen4(navController: NavHostController , age:Int) {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize()
    ) {
        Text(
            text = age.toString(),
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {navController.navigate("screen5") })
    }
}

@Composable
fun MyScreen5(navController: NavHostController , name:String) {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize()
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {  })
    }
}
