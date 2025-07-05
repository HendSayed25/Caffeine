package com.example.caffeine.screens.home.composable2

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import kotlin.math.absoluteValue

@Composable
fun HomePager(
    modifier: Modifier = Modifier
){

    val images = listOf(
        R.drawable.espresso,
        R.drawable.macchiato,
        R.drawable.latte,
        R.drawable.black
    )

    val pagerState  = rememberPagerState (pageCount = {images.size})

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 80.dp),
        pageSpacing = (-5).dp
    ) { page->
        val pageOffset = (
                (pagerState.currentPage - page) + pagerState
                    .currentPageOffsetFraction
                ).absoluteValue

        val easedFraction = FastOutSlowInEasing.transform(1f - pageOffset.coerceIn(0f, 1f))

        val scale = lerp(
            start = 0.8f, stop =  1f, fraction =easedFraction
        )

        val animatedScale by animateFloatAsState(
            targetValue = lerp(0.8f, 1f, easedFraction),
            animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
        )

        val animatedTranslation by animateFloatAsState(
            targetValue = 80 * (1- easedFraction),
            animationSpec = tween(durationMillis = 100, easing = FastOutSlowInEasing)
        )



        Box (
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                scaleX = animatedScale
                scaleY = animatedScale
                translationY = animatedTranslation
            }

        ){
            Image(
                painter = painterResource(images[page]),
                contentDescription = "pager item",
            )
        }

    }

}

@Preview
@Composable
private fun Preview(){
    HomePager()
}