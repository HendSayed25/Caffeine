package com.example.caffeine.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomButton
import com.example.caffeine.screens.home.composable.AppBar
import com.example.caffeine.screens.home.composable2.TextSection
import com.example.caffeine.ui.theme.CaffeineTheme
import com.example.caffeine.ui.theme.fontColor
import com.example.caffeine.ui.theme.subTitleColor
import com.example.caffeine.ui.theme.subTitleColor2
import com.example.caffeine.ui.theme.titleColor
import com.example.caffeine.ui.theme.white

@Composable
fun HomeScreenContent2(
    buttonText : String,
    iconId : Int ,
    onClick : ()-> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(top = 10.dp),
    ) {

        AppBar(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp,bottom =16.dp, top = 16.dp )
        )

        TextSection(
            modifier = Modifier.padding(start = 16.dp)
        )








        Box(
            modifier = Modifier.fillMaxSize()
        ){
            CustomButton(
                modifier = Modifier.align(Alignment.Center),
                text = buttonText,
                iconId = iconId,
                onClick = onClick
            )
        }
    }
}



@Preview
@Composable
private fun Preview(){
    CaffeineTheme {
        HomeScreenContent2(
            buttonText = "Continue",
            iconId = R.drawable.arrow_right2,
            onClick = {}
        )

    }
}

