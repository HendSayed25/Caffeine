package com.example.caffeine.screens.prepareCoffee.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.composable.AppBar

@Composable
fun TopSection(
    modifier: Modifier = Modifier,
    onClickBack :() -> Unit,
    widthOfCup : Int,
){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AppBar(
            modifier = Modifier.padding(16.dp),
            onClickBack = onClickBack
        )

        DoneCoffeeTopSection(
            modifier = Modifier.padding(top=16.dp)
        )

        Image(
            painter = painterResource(R.drawable.cover_of_cup),
            contentDescription = "cover of the cup",
            modifier = Modifier.padding(top=17.dp).width(widthOfCup.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    TopSection(
        onClickBack = {},
        widthOfCup = 280
    )
}