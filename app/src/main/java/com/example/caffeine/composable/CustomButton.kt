package com.example.caffeine.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.black
import com.example.caffeine.ui.theme.lightWhite
import androidx.compose.ui.graphics.ColorFilter

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text : String,
    iconId : Int,
    onClick : ()-> Unit
){


        Button(
            onClick = onClick,
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = black,
                contentColor = lightWhite
            ),
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 32.dp),
           elevation = ButtonDefaults.buttonElevation(defaultElevation = 12.dp)


        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = text,
                    style = TextStyle(
                        fontFamily =  FontFamily(
                            Font(R.font.urbanist_variable_font_wght)
                        ),
                        fontWeight = FontWeight.W700,
                        fontSize = 16.sp,
                        lineHeight = 100.sp,
                    ),

                    )
                Spacer(Modifier.width(8.dp))

                Image(
                    painter = painterResource(id = iconId),
                    contentDescription = "icon", colorFilter = ColorFilter.tint(lightWhite)
                )
            }

        }
    }

@Preview
@Composable
private fun Preview(){
    CustomButton(
        iconId = R.drawable.coffee_icon,
        text = "bring my coffee",
        onClick = {}
    )
}