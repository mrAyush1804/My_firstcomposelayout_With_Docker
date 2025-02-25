package com.example.firstdegincompose.app


sealed class Screen(val route: String) {
    object login: Screen("login")
    object singup : Screen("singup")
}