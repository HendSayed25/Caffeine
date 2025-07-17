package com.example.caffeine.screens.pager.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomText
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
            color = titleColor,
            fontSize = 32.sp,
            fontWeight = FontWeight.W700,
            lineHeight = 100.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(
                Font(R.font.urbanist_bold)
            ),
        )
        CustomText(
            text = "Hend ☀",
            color = subTitleColor,
            fontSize = 32.sp,
            fontWeight = FontWeight.W700,
            lineHeight = 100.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(
                Font(R.font.urbanist_bold)
            ),
        )
        Spacer(Modifier.height(4.dp))
        CustomText(
            text = "What would you like to drink today?",
            color = subTitleColor2,
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
            lineHeight = 100.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(
                Font(R.font.urbanist_bold)
            ),
        )
    }
}

