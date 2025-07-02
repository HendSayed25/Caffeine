package com.example.caffeine.screens.home.composable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.CaffeineTheme
import com.example.caffeine.ui.theme.shadowColor

@Composable
fun GhostShape(
    modifier: Modifier = Modifier
){

    val infiniteTransition = rememberInfiniteTransition()

    val offsetY by infiniteTransition.animateFloat(
        initialValue = -10f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val normalized = (offsetY + 10f) / 20f

    Box(
        modifier = modifier
    ){

        Box(
            modifier = Modifier
                .size(160.dp, 20.dp) //TODO handle the shadow of ghost
                .drawBehind {
                    drawOval(
                        color = shadowColor.copy(alpha = 0.03f + 0.1f * normalized),
                        topLeft = Offset.Zero,
                        size = size,
                        style = Fill
                    )
                }
                .align(Alignment.BottomCenter)
        )

        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = "background image",
            Modifier.offset(y = offsetY.dp-25.dp).size(244.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    CaffeineTheme {
        GhostShape()

    }
}
