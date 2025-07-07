package com.example.caffeine.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomText(
    text: String,
    color: Color ,
    fontSize: TextUnit,
    fontWeight: FontWeight ,
    lineHeight: TextUnit ,
    letterSpacing: TextUnit ,
    textAlign: TextAlign ,
    fontFamily: FontFamily
) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            fontSize = fontSize,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing,
        ),
        color = color,
        textAlign = textAlign,
    )
}
