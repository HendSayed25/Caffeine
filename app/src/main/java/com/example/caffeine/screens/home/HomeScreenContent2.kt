package com.example.caffeine.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomButton
import com.example.caffeine.screens.home.composable.AppBar
import com.example.caffeine.screens.home.composable2.HomePager
import com.example.caffeine.screens.home.composable2.TextSection
import com.example.caffeine.ui.theme.CaffeineTheme
import com.example.caffeine.ui.theme.white

@Composable
fun HomeScreenContent2(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column{
            AppBar(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp,bottom =16.dp, top = 16.dp )
            )

            TextSection(
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(Modifier.height(65.dp))

            HomePager()
        }

        Box(
            modifier = Modifier.padding(bottom = 50.dp)
        ){
            CustomButton(
                text = "Continue",
                iconId = R.drawable.arrow_right,
                onClick = {} // args from navigation
            )
        }
    }
}



@Preview
@Composable
private fun Preview(){
    CaffeineTheme {
        HomeScreenContent2(

        )

    }
}

