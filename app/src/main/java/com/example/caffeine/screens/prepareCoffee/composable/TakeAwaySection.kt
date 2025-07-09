package com.example.caffeine.screens.prepareCoffee.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.CustomText
import com.example.caffeine.ui.theme.takeAwayColor

@Composable
fun TakeAwaySection(
    modifier: Modifier = Modifier,
    isChecked  : Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        CustomToggle(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
        Spacer(Modifier.width(8.dp))
        CustomText(
            text = "Take Away",
            color = takeAwayColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily(
                Font(R.font.urbanist_bold)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    TakeAwaySection(
        isChecked = false,
        onCheckedChange = {}
    )
}