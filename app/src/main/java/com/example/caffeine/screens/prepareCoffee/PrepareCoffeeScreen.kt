package com.example.caffeine.screens.prepareCoffee

import WavyLine
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.composable.CustomButton
import com.example.caffeine.screens.chooseCoffee.composable.CoffeeCupItem
import com.example.caffeine.screens.prepareCoffee.composable.TakeAwaySection
import com.example.caffeine.screens.prepareCoffee.composable.TextSection
import com.example.caffeine.screens.prepareCoffee.composable.TopSection
import com.example.caffeine.ui.theme.white


@Composable
fun PrepareCoffeeScreen(
    modifier: Modifier = Modifier,
    coffeeCupSize : Int,
    navController : NavController
){
    PrepareCoffeeScreenContent(
        coffeeCupSize = coffeeCupSize,
        modifier = modifier,
        onClickNext = {navController.navigate("chooseSnackScreen")},
        onClickBack = {navController.navigateUp()}
    )

}
@Composable
private fun PrepareCoffeeScreenContent(
    modifier: Modifier = Modifier,
    coffeeCupSize : Int,
    onClickNext : ()-> Unit,
    onClickBack : ()-> Unit
) {

    var isChecked by remember { mutableStateOf(false) }
    var widthOfCup = when (coffeeCupSize) {
        150 -> 200
        200 -> 250
        else -> 320
    }
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val density = LocalDensity.current
    val screenHeightPx = with(density) { screenHeight.toPx() }
    var startAnimation by remember { mutableStateOf(false) }
    val offsetYTopSection = remember { Animatable(-screenHeightPx) }
    val offsetYCup = remember { Animatable(0f) }

    LaunchedEffect(Unit) {

        offsetYTopSection.snapTo(-screenHeightPx)
        offsetYTopSection.animateTo(
            targetValue = 53f,
            animationSpec = tween(800, delayMillis = 4000)
        )

        offsetYCup.snapTo(0f)
        offsetYCup.animateTo(
            targetValue = 260f,
            animationSpec = tween(700)
        )

    }

    Box(
        modifier = modifier
            .background(white)
            .fillMaxSize()
    ) {

        CoffeeCupItem(
            coffeeCupSize = coffeeCupSize,
            modifier = Modifier
                .padding(top = if(startAnimation)0.dp else 80.dp)
                .offset(y = offsetYCup.value.dp)
                .align(Alignment.TopCenter)
        )


        if (startAnimation) {
            TopSection(
                modifier = Modifier
                    .offset(y = offsetYTopSection.value.dp)
                    .align(Alignment.TopCenter),
                onClickBack = onClickBack,
                widthOfCup = widthOfCup
            )
        }
        

        if (!startAnimation) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WavyLine(
                    onFinished = { startAnimation = true }
                )

                TextSection(modifier=modifier.padding(top=37.dp))
            }
        } else {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 50.dp,top=16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TakeAwaySection(
                    modifier = Modifier,
                    isChecked = isChecked,
                    onCheckedChange = { isChecked = it }
                )

                CustomButton(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Take snack",
                    iconId = R.drawable.arrow_right,
                    onClick = onClickNext
                )
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
private fun Preview(){
    PrepareCoffeeScreenContent(
        coffeeCupSize = 150,
        onClickNext = {},
        onClickBack = {}
    )
}