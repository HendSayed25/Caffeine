package com.example.caffeine.screens.chooseCoffee.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
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
import com.example.caffeine.ui.theme.LightGrayBackground
import com.example.caffeine.ui.theme.fontColor

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title : String
){
    Row(
        modifier = modifier.fillMaxWidth(),
    ){
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    LightGrayBackground, shape = RoundedCornerShape(100.dp)
                ), contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "right arrow icon",
           )
        }

        Box(
            modifier = Modifier.padding(start = 12.dp,top = 9.5.dp),
        ){
            Text(
                text = title,
                fontFamily = FontFamily(
                    Font(R.font.urbanist_bold)
                ),
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                letterSpacing = 0.25.sp,
                color = fontColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    AppBar(
        title = "Macchiato"
    )
}