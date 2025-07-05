package com.example.caffeine.screens.chooseCoffee.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.LightGrayBackground
import com.example.caffeine.ui.theme.coffeeSizeColor
import com.example.caffeine.ui.theme.coffeeSizeSelectedTxtColor
import com.example.caffeine.ui.theme.coffeeSizeShadow
import com.example.caffeine.ui.theme.coffeeSizeUnSelectedTxtColor
import com.example.caffeine.utils.dropShadow
import androidx.compose.ui.graphics.Color


@Composable
fun CoffeeSize(
    modifier: Modifier = Modifier,
    selectedSize: String,
    onSizeSelected: (String) -> Unit
) {

    Box(
        modifier = modifier.background(LightGrayBackground, shape = RoundedCornerShape(100.dp))
    ) {
        Row {
            CoffeeSizeItem(text = "S", isSelected = selectedSize == "S") { onSizeSelected("S") }
            CoffeeSizeItem(text = "M", isSelected = selectedSize == "M") { onSizeSelected("M") }
            CoffeeSizeItem(text = "L", isSelected = selectedSize == "L") { onSizeSelected("L") }
        }
    }
}


@Composable
private fun CoffeeSizeItem(
    text: String, isSelected: Boolean, onClick: () -> Unit
) {
    val textColor by animateColorAsState(
        targetValue = if (isSelected) coffeeSizeSelectedTxtColor else coffeeSizeUnSelectedTxtColor
    )
    val backgroundColor by animateColorAsState(
        targetValue =  if (isSelected) coffeeSizeColor else Color.Transparent
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
        contentAlignment = Alignment.Center)
    {
        Text(
            text = text,
            fontFamily = FontFamily(
                Font(R.font.urbanist_bold)
            ),
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = textColor
        )
    }
}

@Preview
@Composable
private fun Preview() {

    CoffeeSize(
        selectedSize = "M", onSizeSelected = {}
    )
}