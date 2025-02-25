package com.example.firstdegincompose.screens

import CircleImage
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.firstdegincompose.R
import com.example.firstdegincompose.app.Screen
import com.example.firstdegincompose.commopnents.LoginInputs
import com.example.firstdegincompose.commopnents.loginbtn
import com.example.firstdegincompose.commopnents.normaltext


@Composable
fun loginscreen(navController: NavHostController)
{
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(14.dp)
            .padding(vertical = 25.dp)

    ) {
        val poppinsFontFamily = FontFamily(
            Font(R.font.poppins_semibold, FontWeight.SemiBold)
        )
        Column(modifier = Modifier.fillMaxWidth().padding(5.dp)) {

            normaltext(
                "Hey There",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = poppinsFontFamily,
                aliment = "horizontal"

            )

            normaltext(
                "Login Screen",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = poppinsFontFamily,
                aliment = "horizontal",
                fontSize = 30

            )

            Spacer(modifier = Modifier.padding(top = 30.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                LoginInputs()
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center

            ) {

               loginbtn("Login ",navController,Screen.singup.route)


            }

            Spacer(modifier = Modifier.padding(top = 20.dp))
            Divider(thickness = 1.dp,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 20.dp))

            Spacer(modifier = Modifier.padding(top = 50.dp))
            /** ye horizetal space dene kaam ata ha ***/

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,


                ) {

                CircleImage(
                    painter = painterResource(id = R.drawable.apple), // Use image from resources
                    contentDescription = "Profile Image"
                )
                Spacer(modifier = Modifier.width(16.dp))

                CircleImage(
                    painter = painterResource(id = R.drawable.facebook__1_), // Use image from resources
                    contentDescription = "Profile Image"
                )
                Spacer(modifier = Modifier.width(16.dp))
                CircleImage(
                    painter = painterResource(id = R.drawable.google), // Use image from resources
                    contentDescription = "Profile Image"
                )


            }


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally // Pure Column ko center me align karega
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically, // Row ke andar text vertical center hoga
                    horizontalArrangement = Arrangement.Center // Row ke andar elements horizontally center honge
                ) {
                    normaltext(
                        value = "Don't have an account?",
                        color = Color.Black,
                        fontSize = 14,
                        fontFamily = poppinsFontFamily,
                        aliment = "vertical"
                    )

                    Spacer(modifier = Modifier.width(4.dp)) // Thoda space Sign Up se pehle

                    androidx.compose.material3.Text(
                        text = "Sign Up",
                        color = Color.Blue,  // Blue color ke liye
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            // Sign Up pe click karne ka action
                        }
                    )
                }
            }




        }


    }
}