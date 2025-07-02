package com.example.caffeine.screens.home.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.caffeine.R
import kotlinx.coroutines.delay

@Composable
fun StarIcon(
    modifier: Modifier = Modifier,
){

    var isDarkStar by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(400)
            isDarkStar = !isDarkStar
        }
    }

    AnimatedContent(
        targetState = isDarkStar,
        label = "switching",
        transitionSpec = { // this is not animation only describe the way to transfer from state to another
            fadeIn(
                animationSpec = tween(durationMillis = 300)
            ) togetherWith fadeOut(
                animationSpec = tween(durationMillis = 300)
            )
        }
    ) {
        target->
        Box(
            modifier = modifier
        ) {
            if(target){
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "light star icon",

                )
            }
            else{
                Image(
                    painter = painterResource(R.drawable.light_star),
                    contentDescription = " dark star icon"
                )
            }
        }
    }
}