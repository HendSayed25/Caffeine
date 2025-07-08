package com.example.caffeine.screens.prepareCoffee.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.theme.colonColor
import com.example.caffeine.ui.theme.white

@Composable
fun ColonItem(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .background(white)
            .padding(vertical = 14.dp, horizontal = 12.dp)
    ) {
        Box(
            modifier = Modifier
                .background(
                    colonColor,
                    shape = RoundedCornerShape(100.dp)
                )
                .size(4.dp)
        )
        Spacer(Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .background(
                    colonColor,
                    shape = RoundedCornerShape(100.dp)
                )
                .size(4.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    ColonItem()
}