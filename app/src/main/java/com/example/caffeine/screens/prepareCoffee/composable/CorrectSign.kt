package com.example.caffeine.screens.prepareCoffee.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.screens.chooseCoffee.composable.CoffeeCupItem
import com.example.caffeine.ui.theme.coffeeSizeColor
import com.example.caffeine.ui.theme.coffeeSizeShadow
import com.example.caffeine.utils.dropShadow

@Composable
fun CorrectSign(
    modifier: Modifier = Modifier
){

    Box(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 10.dp)
            .size(56.dp)
            .dropShadow(
                shape = CircleShape,
                color = coffeeSizeShadow,
                blur = 16.dp,
                offsetX = 0.dp,
                offsetY = 6.dp,
                spread = 0.dp
            )
            .clip(CircleShape)
            .background(coffeeSizeColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.correct_sign),
            contentDescription = "correct sign"
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    CorrectSign()
}