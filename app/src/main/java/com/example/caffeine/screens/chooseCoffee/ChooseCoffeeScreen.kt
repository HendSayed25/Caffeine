package com.example.caffeine.screens.chooseCoffee

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.composable.CustomButton
import com.example.caffeine.screens.chooseCoffee.composable.AppBar
import com.example.caffeine.screens.chooseCoffee.composable.CoffeeCupItem
import com.example.caffeine.screens.chooseCoffee.composable.CoffeeSize
import com.example.caffeine.screens.chooseCoffee.composable.coffeeBeans.CoffeeBeans
import com.example.caffeine.ui.theme.white

@Composable
fun ChooseCoffeeScreen(
    navController: NavController, coffeeName: String
) {
    ChooseCoffeeScreenContent(
        onClickNext = { coffeeCupSize ->
            navController.navigate("prepareCoffeeScreen/$coffeeCupSize")
        },
        onClickBack = { navController.navigateUp() },
        coffeeName = coffeeName
    )
}

@Composable
private fun ChooseCoffeeScreenContent(
    onClickNext: (Int) -> Unit, onClickBack: () -> Unit, coffeeName: String
) {
    var selectedSize by remember { mutableStateOf("M") }
    var selectedCoffeeIndex by remember { mutableIntStateOf(1) }
    var animateBeans by remember { mutableStateOf(false) }
    var isCoffeeDown by remember { mutableStateOf(false) }

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val density = LocalDensity.current
    val screenHeightPx = with(density) { screenHeight.toPx() }

    val coffeeCupSize = when (selectedSize) {
        "S" -> 150
        "M" -> 200
        "L" -> 400
        else -> 150
    }

    val offsetY = remember { Animatable(-screenHeightPx) }

    LaunchedEffect(isCoffeeDown) {
        if (isCoffeeDown) {
            offsetY.snapTo(-screenHeightPx)
            offsetY.animateTo(
                targetValue = 5f,
                animationSpec = tween(500)
            )
            animateBeans = false
        } else {
            animateBeans = true
            offsetY.animateTo(
                targetValue = -screenHeightPx,
                animationSpec = tween(500)
            )
            animateBeans = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        AppBar(
            modifier = Modifier.padding(16.dp), title = coffeeName, onClickBack = onClickBack
        )

        Box(contentAlignment = Alignment.TopCenter) {
            if (animateBeans) {
                Image(
                    painter = painterResource(
                        if (coffeeCupSize == 150) R.drawable.small_coffe
                        else R.drawable.big_coffee
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(
                            if(coffeeCupSize==150)130.dp
                            else 150.dp
                        )
                        .offset(y = offsetY.value.dp)
                )
            }
            CoffeeCupItem(
                modifier = Modifier
                    .size(360.dp, 341.dp)
                    .padding(top = 25.dp),
                coffeeCupSize = coffeeCupSize,
            )
        }

        CoffeeSize(
            modifier = Modifier.padding(top = 20.dp),
            selectedSize = selectedSize,
            onSizeSelected = { selectedSize = it }
        )
        Spacer(Modifier.height(16.dp))

        CoffeeBeans(
            selectedIndex = selectedCoffeeIndex,
            onSelectedIndex = {
                if (selectedCoffeeIndex == it) {
                    isCoffeeDown = !isCoffeeDown
                    animateBeans = true
                } else {
                    selectedCoffeeIndex = it
                    isCoffeeDown = true
                    animateBeans = true
                }
            }
        )

        Spacer(Modifier.weight(1f))
        Box(modifier = Modifier.padding(bottom = 50.dp)) {
            CustomButton(
                text = "Continue",
                iconId = R.drawable.arrow_right,
                onClick = { onClickNext(coffeeCupSize) }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ChooseCoffeeScreenContent(
        onClickNext = {}, onClickBack = {}, coffeeName = "Macchiato"
    )
}
