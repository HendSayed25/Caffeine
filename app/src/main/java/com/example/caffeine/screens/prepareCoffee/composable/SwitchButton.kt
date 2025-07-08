package com.example.caffeine.screens.prepareCoffee.composable


import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.screens.prepareCoffee.composable.switchState.OffState
import com.example.caffeine.screens.prepareCoffee.composable.switchState.OnState
import com.example.caffeine.ui.theme.coffeeSizeColor
import com.example.caffeine.ui.theme.coffeeSizeUnSelectedTxtColor
import com.example.caffeine.ui.theme.switchOnColor
import com.example.caffeine.ui.theme.switchOnTextColor

@Composable
fun CustomToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val textColor = animateColorAsState(
        targetValue = if(checked)coffeeSizeUnSelectedTxtColor else switchOnTextColor,
        animationSpec = tween(durationMillis = 200, easing = LinearEasing)
    )
    val backgroundColor  = animateColorAsState(
        targetValue = if (checked) switchOnColor else coffeeSizeColor,
        animationSpec = tween(durationMillis = 200, easing = LinearEasing)
    )

    Box(
        modifier = Modifier.width(78.dp)
            .clip(RoundedCornerShape(100))
            .background(backgroundColor.value)
            .clickable { onCheckedChange(!checked) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Crossfade(targetState = checked,
                animationSpec = tween(durationMillis = 300, easing = LinearEasing)
            )
            { isChecked ->
                if (isChecked) {
                    OffState(textColor.value)

                } else {
                    OnState(textColor.value)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview(){
    CustomToggle (
        checked = true,
        onCheckedChange = {}
    )
}
