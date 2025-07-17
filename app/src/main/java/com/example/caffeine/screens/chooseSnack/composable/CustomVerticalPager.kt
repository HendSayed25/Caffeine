package com.example.caffeine.screens.chooseSnack.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import kotlin.math.abs

@Composable
fun CustomVerticalPager(
    onClickNext: (Int) -> Unit
) {

    val snacks = listOf(
        R.drawable.cupcake_card,
        R.drawable.chocklate_card,
        R.drawable.crosso_card,
        R.drawable.cinabon_catd,
        R.drawable.oreo_card,
    )

    val pagerState = rememberPagerState(
        pageCount = { snacks.size }
    )

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val paddingValue = screenHeight * 0.55f

    VerticalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(350.dp),
        pageSpacing = (-250).dp,
        contentPadding = PaddingValues(bottom = paddingValue, top = 32.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) { page ->

        Box(
            modifier = Modifier
                .padding(start = 60.dp)
        ) {

            val pageOffset = (
                    (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                    ).coerceIn(-1f, 1f)

            val scale = 1f - (abs(pageOffset) * 0.1f)
            val animatedScale by animateFloatAsState(scale)

            val isSelected = pagerState.currentPage == page
            val nextSelected = pagerState.currentPage + 1 == page
            val prevSelected = pagerState.currentPage - 1 == page

            val offsetX by animateFloatAsState(
                if (isSelected) -100f
                else if (nextSelected) -170f
                else if (prevSelected) -300f
                else -400f
            )

            val offsetY by animateFloatAsState(
                if (isSelected) 0f
                else if (nextSelected) 40f
                else if (prevSelected) 150f
                else 30f
            )

            val baseRotation = when {
                isSelected -> 0f
                prevSelected -> -20f
                nextSelected -> 20f
                else -> 10f
            }
            val rotation by animateFloatAsState(
                targetValue = baseRotation * (1 - abs(pageOffset))
            )

            Box(
                modifier = Modifier
                    .scale(animatedScale)
                    .offset(x = offsetX.dp, y = offsetY.dp)
                    .graphicsLayer {
                        rotationZ = rotation
                    }
            ) {
                Image(
                    painter = painterResource(snacks[page]),
                    contentDescription = "snack image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onClickNext(page) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CustomVerticalPager { }
}
