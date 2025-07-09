package com.example.caffeine.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.LightGrayBackground

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    onClickBack : () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Box(
            modifier = Modifier
                .size(48.dp)
                .clickable{
                    onClickBack()
                }
                .background(
                    LightGrayBackground, shape = RoundedCornerShape(100.dp)
                ), contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.cancel_sign),
                contentDescription = "cancel icon",

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppBar(
        onClickBack = {}
    )
}