package com.example.caffeine.screens.home.composable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
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
) {

    val infiniteTransition = rememberInfiniteTransition()

    val offsetY by infiniteTransition.animateFloat(
        initialValue = -10f, targetValue = 10f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing, delayMillis = 10),
            repeatMode = RepeatMode.Reverse
        )
    )

    val normalized = (offsetY + 10f) / 20f

    Box(
        modifier = modifier
    ) {

        Box(
            modifier = Modifier
                .size(160.dp, 27.dp)
                .offset(y = (-offsetY * 0.4f).dp + 10.dp)
                .blur(12.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .drawBehind {
                    drawOval(
                        color = shadowColor.copy(alpha = 0.1f + 0.1f * normalized),
                        topLeft = Offset.Zero,
                        size = size,
                        style = Fill
                    )
                }
                .align(Alignment.BottomCenter))


        Image(
            painter = painterResource(R.drawable.ghost),
            contentDescription = "Ghost",
            modifier = Modifier
                .fillMaxSize()
                .offset(y = offsetY.dp - 35.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CaffeineTheme {
        GhostShape()

    }
}
