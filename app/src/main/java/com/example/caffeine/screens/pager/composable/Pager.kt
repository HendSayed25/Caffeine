package com.example.caffeine.screens.pager.composable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.caffeine.R
import kotlin.math.absoluteValue

@Composable
fun HomePager(
    modifier: Modifier = Modifier,
    onCoffeeSelected: (String) -> Unit
) {

    val coffees = listOf(
        "Espresso" to R.drawable.espresso,
        "Macchiato" to R.drawable.macchiato,
        "Latte" to R.drawable.latte,
        "Black" to R.drawable.black
    )

    val pagerState = rememberPagerState(pageCount = { coffees.size })

    LaunchedEffect(pagerState.currentPage) {
        onCoffeeSelected(coffees[pagerState.currentPage].first)
    }

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 80.dp),
        pageSpacing = (-15).dp
    ) { page ->
        val pageOffset = (
                (pagerState.currentPage - page) + pagerState
                    .currentPageOffsetFraction
                ).absoluteValue

        val easedFraction = LinearEasing.transform(1f - pageOffset.coerceIn(0f, 1f))

        val scale by animateFloatAsState(
            lerp(start = 0.6f, stop = 1f, fraction = easedFraction)

        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .scale(scale)
                .offset(y = (-25).dp)

        ) {
            Image(
                painter = painterResource(coffees[page].second),
                contentDescription = "pager item",
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    HomePager(
        onCoffeeSelected = {}
    )
}