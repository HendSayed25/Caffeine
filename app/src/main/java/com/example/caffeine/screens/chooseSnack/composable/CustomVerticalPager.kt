package com.example.caffeine.screens.chooseSnack.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun CustomVerticalPager(
    modifier: Modifier = Modifier,
    onClickNext : () -> Unit
) {
    val snacks = listOf(
        R.drawable.chocklate_card,
        R.drawable.crosso_card,
        R.drawable.cupcake_card,
        R.drawable.cinabon_catd,
        R.drawable.oreo_card,
    )

    val pagerState = rememberPagerState(pageCount = { snacks.size })

    VerticalPager(
        state = pagerState,
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 32.dp),
        pageSpacing = 16.dp
    ) { page ->

        Image(
            painter = painterResource(snacks[page]),
            contentDescription = "snack image",
            modifier = Modifier
                .fillMaxWidth() .clickable {
                    onClickNext()
                }
        )
    }
}

