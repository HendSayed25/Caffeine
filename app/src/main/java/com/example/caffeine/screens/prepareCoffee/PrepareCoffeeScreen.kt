package com.example.caffeine.screens.prepareCoffee.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caffeine.screens.chooseCoffee.composable.CoffeeCupItem
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
    )

}
@Composable
private fun PrepareCoffeeScreenContent(
    modifier: Modifier = Modifier,
    coffeeCupSize : Int,
    onClickNext : ()-> Unit,
    ){
    Column (
        modifier = modifier.background(white).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CoffeeCupItem(
            coffeeCupSize = coffeeCupSize,
            modifier = Modifier.padding(top=80.dp)
        )

        Spacer(Modifier.weight(1f))

        TextSection(
            modifier = Modifier.padding(bottom = 64.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    PrepareCoffeeScreenContent(
        coffeeCupSize = 150,
        onClickNext = {}
    )
}
