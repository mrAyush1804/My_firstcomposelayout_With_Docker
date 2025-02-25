package com.example.firstdegincompose.commopnents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstdegincompose.R
import com.example.firstdegincompose.app.Screen


@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = colorResource(R.color.black),
    textColor: Color = colorResource(R.color.white),
    modifier: Modifier = Modifier,

) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor),

    ) {
        Text(text = text, color = textColor)
    }
}

@Composable
fun loginbtn(text: String,navController: NavController,rout:String)
{
    CustomButton(
        text = text,
        onClick = { navController.navigate(rout) },

    )

}
