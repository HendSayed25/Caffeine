import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.caffeine.ui.theme.wavyLineColor

@Composable
fun WavyLine(
    onFinished: () -> Unit

) {

    val phase = remember { Animatable(0f) }

    LaunchedEffect(Unit) {

        phase.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 3000, easing = FastOutLinearInEasing)
        )

        phase.animateTo(
            targetValue = 0.6f,
            animationSpec = tween(durationMillis = 2000, easing = FastOutLinearInEasing)
        )

        onFinished()
    }

    Canvas(modifier = Modifier.fillMaxWidth()) {
        val waveHeight = 91f
        val waveLength = 300f
        val centerY = size.height / 2

        val totalLength = size.width
        val offsetY = 200f

        val path = Path()

        path.moveTo(0f, centerY - offsetY)
        path.lineTo(0f, centerY )

        var x = 0f
        while (x < totalLength) {
            path.relativeCubicTo(
                waveLength / 4, -waveHeight, waveLength * 3 / 4, -waveHeight, waveLength, 0f
            )
            path.relativeCubicTo(
                waveLength / 4, waveHeight, waveLength * 3 / 4, waveHeight, waveLength, 0f
            )
            x += waveLength * 2
        }

        val visibleLength = totalLength * phase.value

        val animatedPath = Path()
        animatedPath.moveTo(0f, centerY)

        var currentLength = 0f
        x = 0f

        while (currentLength < visibleLength && x < totalLength) {
            animatedPath.relativeQuadraticBezierTo(
                waveLength / 4, -waveHeight, waveLength / 2, 0f
            )
            currentLength += waveLength / 2

            if (currentLength >= visibleLength) break

            animatedPath.relativeQuadraticBezierTo(
                waveLength / 4, waveHeight, waveLength / 2, 0f
            )
            currentLength += waveLength / 2

            x += waveLength
        }

        drawPath(
            path = animatedPath,
            color = wavyLineColor,
            style = Stroke(
                width = 5f, cap = StrokeCap.Round
            ),
        )
    }
}
