package com.example.firstdegincompose.screens

import CircleImage
import ProfileScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstdegincompose.R
import com.example.firstdegincompose.commopnents.ShowInputs

import com.example.firstdegincompose.commopnents.normaltext
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
            ShowInputs()
            Divider(thickness = 1.dp,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 20.dp))

            Spacer(modifier = Modifier.padding(10.dp))
            /** ye horizetal space dene kaam ata ha ***/

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,


                ) {

                CircleImage(
                    painter = painterResource(id = R.drawable.apple), // Use image from resources
                    contentDescription = "Profile Image"
                )
                Spacer(modifier = Modifier.width(16.dp))

                CircleImage(
                    painter = painterResource(id = R.drawable.facebook), // Use image from resources
                    contentDescription = "Profile Image"
                )
                Spacer(modifier = Modifier.width(16.dp))
                CircleImage(
                    painter = painterResource(id = R.drawable.google), // Use image from resources
                    contentDescription = "Profile Image"
                )
            }



        }


    }
}


@Preview
@Composable
fun DifaultpreviewSingupscreen() {
    Singupscreen()
}

