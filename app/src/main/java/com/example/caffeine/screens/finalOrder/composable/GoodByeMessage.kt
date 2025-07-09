package com.example.caffeine.screens.finalOrder.composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
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
import com.example.caffeine.composable.CustomText
import com.example.caffeine.ui.theme.subTitleColor2

@Composable
fun GoodByeMessage(
    modifier: Modifier = Modifier,
    text : String
){

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){

        CustomText(
            text = text,
            color = subTitleColor2,
            fontSize = 22.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily(
                Font(R.font.urbanist_bold)
            )
        )
        Spacer(Modifier.width(8.dp))

        Image(
            painter = painterResource(R.drawable.magic_wand),
            contentDescription = "good bye icon in final screen",
        )

    }
}

@Preview (showBackground = true)
@Composable
private fun Preview(){
    GoodByeMessage(
        text = "Bon appétit",
    )
}