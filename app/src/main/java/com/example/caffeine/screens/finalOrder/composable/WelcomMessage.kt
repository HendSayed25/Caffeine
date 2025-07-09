package com.example.caffeine.screens.finalOrder.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.caffeine.ui.theme.coffeeSizeColor

@Composable
fun WelcomeMessage(
    modifier: Modifier = Modifier,
    text : String
){

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(R.drawable.coffee_beans),
            contentDescription = "coffee beans icon in final screen",
            modifier = Modifier.size(32.dp),
            colorFilter = ColorFilter.tint(color = coffeeSizeColor)
        )

        Box(
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 3.5.dp)
        ){

            CustomText(
                text = text,
                color = coffeeSizeColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 100.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.sniglet_regular)
                )
            )
        }

        Image(
            painter = painterResource(R.drawable.coffee_beans),
            contentDescription = "coffee beans icon in final screen",
            modifier = Modifier.size(32.dp),
            colorFilter = ColorFilter.tint(color = coffeeSizeColor)
        )
    }
}

@Preview (showBackground = true)
@Composable
private fun Preview(){
    WelcomeMessage(
        text = "More Espresso, Less Depresso"
    )
}