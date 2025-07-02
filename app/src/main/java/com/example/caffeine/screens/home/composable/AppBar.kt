package com.example.caffeine.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 24.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "profile icon",
            modifier = Modifier.size(48.dp)
        )

        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    LightGrayBackground, shape = RoundedCornerShape(100.dp)
                ), contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "plus icon",

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppBar()
}