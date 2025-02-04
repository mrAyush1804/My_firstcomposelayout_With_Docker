package com.example.firstdegincompose.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.firstdegincompose.screens.DifaultpreviewSingupscreen

@Composable
fun postmanapp() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
         DifaultpreviewSingupscreen()
    }
}