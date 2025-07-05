package com.example.caffeine.screens.chooseCoffee

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomButton
import com.example.caffeine.screens.chooseCoffee.composable.AppBar
import com.example.caffeine.screens.chooseCoffee.composable.coffeeBeans.CoffeeBeans
import com.example.caffeine.screens.chooseCoffee.composable.CoffeeCupItem
import com.example.caffeine.screens.chooseCoffee.composable.CoffeeSize
import com.example.caffeine.ui.theme.white

@Composable
fun ChooseCoffeeScreen(){

    var selectedSize by remember { mutableStateOf("M") }
    var selectedCoffeeIndex by remember { mutableIntStateOf(1) }

    val coffeeCupSize = when (selectedSize) {
        "S" -> 150
        "M" -> 200
        "L" -> 400
        else -> 150
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,

            ){
            AppBar(
                modifier = Modifier.padding(16.dp),
                title = "Macchiato" //will given by args
            )

            CoffeeCupItem(
                modifier = Modifier.size(360.dp, 341.dp),
                coffeeCupSize = coffeeCupSize,
            )

            CoffeeSize(
                modifier = Modifier.padding(top = 10.dp),
                selectedSize = selectedSize,
                onSizeSelected = { selectedSize = it }
            )
            Spacer(Modifier.height(16.dp))

            CoffeeBeans(
                selectedIndex = selectedCoffeeIndex,
                onSelectedIndex = { selectedCoffeeIndex = it }
            )

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
    ChooseCoffeeScreen()

}
