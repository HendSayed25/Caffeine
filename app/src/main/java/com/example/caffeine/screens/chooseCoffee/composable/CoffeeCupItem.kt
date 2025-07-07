package com.example.caffeine.screens.chooseCoffee.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomText
import com.example.caffeine.ui.theme.fontColor

@Composable
fun CoffeeCupItem(
    modifier: Modifier = Modifier, coffeeCupSize: Int
) {
    Box(
        modifier = modifier.size(360.dp, 341.dp)
    ) {

        Box(
            modifier = Modifier.padding(start = 16.dp,top=64.dp)
        ){
            CustomText(
                text = "$coffeeCupSize ML",
                color = fontColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 100.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.urbanist_medium)
                ),
            )
        }



        Image(
            painter = painterResource(
                if (coffeeCupSize == 400) R.drawable.macchiato_400ml
                else if (coffeeCupSize == 200) R.drawable.macchiato_200ml
                else R.drawable.macchiato_150ml
            ),
            contentDescription = "coffee cup image",
            modifier = Modifier.align(Alignment.Center)
        )

        Image(
            painter = painterResource(
                if (coffeeCupSize == 400 || coffeeCupSize == 200) R.drawable.coffee_logo_64
                else R.drawable.coffee_logo_40
            ),
            contentDescription = "coffee logo icon",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    CoffeeCupItem(
        coffeeCupSize = 200
    )
}
