package com.example.caffeine.screens.finalOrder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.AppBar
import com.example.caffeine.composable.CustomButton
import com.example.caffeine.composable.CustomText
import com.example.caffeine.screens.finalOrder.composable.GoodByeMessage
import com.example.caffeine.screens.finalOrder.composable.WelcomeMessage
import com.example.caffeine.ui.theme.subTitleColor2
import com.example.caffeine.ui.theme.white

@Composable
fun FinalOrderScreen(){


}

@Composable
private fun FinalOrderContent(
    modifier : Modifier = Modifier,
    onClickBack : () -> Unit
){
    Column (
        modifier = modifier.background(white).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AppBar(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp,bottom =16.dp, top = 16.dp ),
            onClickBack = onClickBack
        )

        WelcomeMessage(
            modifier = Modifier.padding(top=24.dp, bottom = 24.dp, start = 8.dp, end = 8.dp),
            text = "More Espresso, Less Depresso"
        )

        Image(
            painter = painterResource(R.drawable.cupcake), //will changed by args
            contentDescription = "snack icon that user choose",
            modifier = Modifier.padding(horizontal = 30.dp).weight(1f)
        )

        GoodByeMessage(
            text = "Bon appétit",
            modifier = Modifier.padding(start = 105.dp, end = 105.dp, top = 12.dp)
        )
        Spacer(Modifier.weight(1f))

        CustomButton(
            modifier = Modifier.padding(bottom = 50.dp),
            text = "Thank youuu",
            iconId = R.drawable.arrow_right,
            onClick = {}
        )

    }
}

@Preview
@Composable
private fun Preview(){
    FinalOrderContent(
        onClickBack = {}
    )
}