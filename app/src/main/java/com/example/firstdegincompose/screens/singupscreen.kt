package com.example.firstdegincompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstdegincompose.commopnents.normaltext
import com.example.firstdegincompose.commopnents.show
import com.example.firstdegincompose.commopnents.showEditText


@Composable
fun Singupscreen() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(14.dp)
            .padding(vertical = 20.dp)

    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            normaltext(
                "Hey There",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                aliment = "horizontal"
            )
            Spacer(modifier = Modifier.padding(10.dp))
            normaltext(
                "Create new Account",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                aliment = "horizontal",
                fontSize = 30,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(10.dp))
            show()



        }


    }
}


@Preview
@Composable
fun DifaultpreviewSingupscreen() {
    Singupscreen()
}

