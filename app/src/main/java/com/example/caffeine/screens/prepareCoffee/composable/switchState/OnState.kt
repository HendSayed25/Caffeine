package com.example.caffeine.screens.prepareCoffee.composable.switchState

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomText

@Composable
fun OnState(
    textColor : Color
){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(R.drawable.coffee_toggle),
            contentDescription = "switch button icon",
            modifier = Modifier.size(width = 40.52.dp, height = 40.dp)
        )

        Box(
            modifier = Modifier.padding(start = 7.dp,top=14.dp, bottom =14.dp,end=14.dp)

        ) {
            CustomText(
                text = "ON",
                color = textColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 100.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.urbanist_bold))
            )
        }
    }
}