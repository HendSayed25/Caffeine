package com.example.caffeine.screens.chooseSnack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.composable.AppBar
import com.example.caffeine.composable.CustomText
import com.example.caffeine.screens.chooseSnack.composable.CustomVerticalPager
import com.example.caffeine.ui.theme.fontColor
import com.example.caffeine.ui.theme.white


@Composable
fun ChooseSnackScreen(
    navController : NavController
){
    ChooseSnackScreenContent(
        onNextClick = {navController.navigate("finalOrder")},
        onClickBack = {navController.navigateUp()}

    )
}
@Composable
fun ChooseSnackScreenContent(
    onNextClick : () -> Unit,
    onClickBack : () -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(top = 30.dp),
    ){
        AppBar(
            modifier = Modifier.padding(16.dp),
            onClickBack = onClickBack
        )

        Box(
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 16.dp)
        ){
            CustomText(
                text = "Take your snack",
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

        CustomVerticalPager(
            onClickNext = onNextClick
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    ChooseSnackScreenContent(
        onClickBack = {},
        onNextClick = {}
    )
}
