package com.example.caffeine.screens.home.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.CaffeineTheme
import com.example.caffeine.ui.theme.fontColor

@Composable
fun IntroductionText(
    modifier: Modifier = Modifier,
) {

    Column (
        modifier = modifier
    ){

        Row(
            modifier = Modifier.padding(start = 50.dp),
        ) {
            CustomText("Hocus")
            Spacer(Modifier.width(30.dp))
            StarIcon()
        }

        Spacer(Modifier.height(5.dp))

        Row(Modifier.padding(start = 5.dp)) {
            StarIcon()
            Spacer(Modifier.width(25.dp))
            CustomText("Pocus")
        }

        Spacer(Modifier.height(5.dp))

        CustomText("I Need Coffee")

        Spacer(Modifier.height(5.dp))

        Row {
            Spacer(Modifier.width(45.dp))
            CustomText("to Focus")
        }

        Spacer(Modifier.height(5.dp))

        Row(
            Modifier.padding(start = 195.dp)
        ) {
            StarIcon()

        }
    }

}
@Composable
fun CustomText(
    text:String
){
    Text(
        text = text, style = TextStyle(
            fontFamily = FontFamily(
                Font(R.font.sniglet_regular)
            ),
            fontWeight = FontWeight.W400,
            fontSize = 32.sp,
            lineHeight = 50.sp,
            letterSpacing = 0.25.sp,
        ), color = fontColor, textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CaffeineTheme {
        IntroductionText()
    }
}

