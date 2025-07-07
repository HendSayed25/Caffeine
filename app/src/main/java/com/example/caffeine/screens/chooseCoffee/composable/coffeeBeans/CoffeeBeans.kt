package com.example.caffeine.screens.chooseCoffee.composable.coffeeBeans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomText
import com.example.caffeine.ui.theme.LightGrayBackground
import com.example.caffeine.ui.theme.coffeeSizeUnSelectedTxtColor


@Composable
fun CoffeeBeans(
    modifier: Modifier = Modifier, selectedIndex: Int, onSelectedIndex: (Int) -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .background(LightGrayBackground, shape = RoundedCornerShape(100.dp))
        ) {
            Row{
                CoffeeBeansItem(isSelected = selectedIndex == 0) { onSelectedIndex(0) }
                CoffeeBeansItem(isSelected = selectedIndex == 1) { onSelectedIndex(1) }
                CoffeeBeansItem(isSelected = selectedIndex == 2) { onSelectedIndex(2) }
            }
        }

        Row(
            modifier = Modifier.padding(top=2.dp),
            horizontalArrangement = Arrangement.spacedBy (45.dp),
        ){
            CustomText(
                text = "Low",
                color = coffeeSizeUnSelectedTxtColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 100.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.urbanist_medium)
                )
            )
            CustomText(
                text = "Medium",
                color = coffeeSizeUnSelectedTxtColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 100.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.urbanist_medium)
                )
            )
            CustomText(
                text = "High",
                color = coffeeSizeUnSelectedTxtColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 100.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.urbanist_medium)
                )
            )
        }
    }

}




@Preview
@Composable
private fun Preview() {

    CoffeeBeans(
        selectedIndex = 1, onSelectedIndex = {})

}