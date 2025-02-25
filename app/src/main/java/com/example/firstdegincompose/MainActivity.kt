package com.example.firstdegincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstdegincompose.app.Screen
import com.example.firstdegincompose.app.postmanapp
import com.example.firstdegincompose.screens.Singupscreen
import com.example.firstdegincompose.screens.loginscreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.login.route) {
                composable("login") { loginscreen(navController) }
                composable("singup") { Singupscreen(navController) }
            }

        }
    }
}
