package com.example.caffeine.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomButton
import com.example.caffeine.screens.home.composable.AppBar
import com.example.caffeine.screens.home.composable.GhostShape
import com.example.caffeine.screens.home.composable.IntroductionText
import com.example.caffeine.ui.theme.CaffeineTheme
import com.example.caffeine.ui.theme.white

@Composable
fun HomeScreen(
    buttonText : String,
    iconId : Int ,
    onClick : ()-> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AppBar(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp,bottom =24.dp, top = 16.dp )
        )

        IntroductionText(
            modifier = Modifier.weight(1f)
        )

        GhostShape(
            modifier = Modifier.weight(1f)
        )

         Box(
             modifier = Modifier.weight(1f)
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
        HomeScreen(
            buttonText = "bring my coffee",
            iconId = R.drawable.coffee_icon,
            onClick = {}
        )

    }
}