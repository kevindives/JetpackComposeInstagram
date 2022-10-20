package com.magicworld.jetpackcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.magicworld.jetpackcomposeinstagram.login.ui.LoginScreen
import com.magicworld.jetpackcomposeinstagram.login.ui.LoginViewModel
import com.magicworld.jetpackcomposeinstagram.model.Routes
import com.magicworld.jetpackcomposeinstagram.scaffold.MyScaffold
import com.magicworld.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme

class MainActivity : ComponentActivity() {

    private val loginViewModel : LoginViewModel by viewModels()

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScaffold()
                    //LoginScreen(loginViewModel)
                    val navigationController = rememberNavController()
                    /*NavHost(
                        navController = navigationController,
                        startDestination = Routes.Screen1.route
                    ) {
                        composable(Routes.Screen1.route) { MyScreen1(navigationController) }
                        composable(Routes.Screen2.route) { MyScreen2(navigationController) }
                        composable(Routes.Screen3.route) { MyScreen3(navigationController) }
                        composable(
                            Screen4.route,
                            arguments = listOf(navArgument("age") { type = NavType.IntType })
                        ) { backStackEntry ->
                            MyScreen4(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Screen5.route,
                            arguments = listOf(navArgument("name") { defaultValue = "pepe" })
                        ) { backStackEntry ->
                            MyScreen5(
                                navigationController,
                                backStackEntry.arguments?.getString("name")!!
                            )
                        }
                    }*/
                }
            }
        }
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_10)
@Composable
fun DefaultPreview() {
    JetpackComposeInstagramTheme {

    }
}