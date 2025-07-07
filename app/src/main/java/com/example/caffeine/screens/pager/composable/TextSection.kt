package com.example.caffeine.screens.pager.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.subTitleColor
import com.example.caffeine.ui.theme.subTitleColor2
import com.example.caffeine.ui.theme.titleColor

@Composable
fun TextSection(
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
    ){
        CustomText(
            text = "Good Morning",
            size = 32,
            fontColor = titleColor
        )
        CustomText(
            text = "Hamsa ☀",
            size = 32,
            fontColor = subTitleColor
        )
        Spacer(Modifier.height(4.dp))
        CustomText(
            text = "What would you like to drink today?",
            size = 16,
            fontColor = subTitleColor2
        )
    }

}

@Composable
private fun CustomText(
    text : String,
    size : Int,
    fontColor : Color
){
    Text(
        text = text, style = TextStyle(
            fontFamily = FontFamily(
                Font(R.font.urbanist_bold)
            ),
            fontWeight = FontWeight.W700,
            fontSize = size.sp,
            letterSpacing = 0.25.sp,
        ), color = fontColor, textAlign = TextAlign.Center
    )

}