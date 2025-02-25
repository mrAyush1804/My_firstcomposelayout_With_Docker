package com.example.firstdegincompose.commopnents

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.firstdegincompose.R

@Composable
fun normaltext(
    value: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    aliment:String="center",
    fontWeight: FontWeight = FontWeight.Normal,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: Int = 18,
    fontFamily: FontFamily = FontFamily.Default

    ) {

    val alimentmodifer=when(aliment.lowercase())
    {
        "vertical" -> Modifier.fillMaxHeight().wrapContentHeight(Alignment.CenterVertically)
        "horizontal" -> Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
        else -> Modifier.fillMaxSize().wrapContentSize(Alignment.BottomCenter)
    }
    val dynamicStyle = TextStyle(
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        fontFamily = fontFamily,
        color = color
    )
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_semibold, FontWeight.SemiBold)
    )
    Text(
        text = value,
        modifier = Modifier.then(alimentmodifer),
        style = dynamicStyle.copy(color = color),
        fontFamily = poppinsFontFamily

    )



}