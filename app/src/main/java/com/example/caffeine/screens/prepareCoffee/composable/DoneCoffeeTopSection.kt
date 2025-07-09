package com.example.caffeine.screens.prepareCoffee.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomText
import com.example.caffeine.ui.theme.fontColor


@Composable
fun DoneCoffeeTopSection(
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        CorrectSign()
        Spacer(Modifier.height(24.dp))
        CustomText(
            text = "Your coffee is ready,",
            color = fontColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.W700,
            lineHeight = 100.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(
                Font(R.font.urbanist_bold)
            )
        )
        CustomText(
            text = "Enjoy",
            color = fontColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.W700,
            lineHeight = 100.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(
                Font(R.font.urbanist_bold)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    DoneCoffeeTopSection()
}