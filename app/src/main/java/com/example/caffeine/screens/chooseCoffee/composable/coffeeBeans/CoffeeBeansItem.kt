package com.example.caffeine.screens.chooseCoffee.composable.coffeeBeans

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.coffeeSizeColor
import com.example.caffeine.ui.theme.coffeeSizeShadow
import com.example.caffeine.utils.dropShadow

@Composable
fun CoffeeBeansItem(
    isSelected: Boolean, onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) coffeeSizeColor else Color.Transparent
    )


    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(40.dp)
            .then(
                if (isSelected) Modifier.dropShadow(
                    shape = CircleShape,
                    color = coffeeSizeShadow,
                    blur = 16.dp,
                    offsetX = 0.dp,
                    offsetY = 6.dp,
                    spread = 0.dp
                )
                else Modifier
            )
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center) {
        if(isSelected)
            Image(
                painter = painterResource(R.drawable.coffee_beans), contentDescription = "coffee beans"
            )
    }
}