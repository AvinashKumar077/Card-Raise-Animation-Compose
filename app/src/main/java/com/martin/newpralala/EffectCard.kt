package com.martin.newpralala

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage

@Composable
fun EffectCard(isSelected: Boolean, onSelect: () -> Unit) {
    val elevation by animateDpAsState(
        targetValue = if (isSelected) 16.dp else 0.dp,
        animationSpec = tween(durationMillis = 700),
        label = "cardElevation"
    )

    val translationY by animateDpAsState(
        targetValue = if (isSelected) (-8).dp else 0.dp,
        animationSpec = tween(durationMillis = 400),
        label = "imageTranslation"
    )

    val borderColor by animateColorAsState(
        targetValue = if (isSelected) Color(0xffB9CDF5) else Color(0xffDAE3F2),
        animationSpec = tween(durationMillis = 700),
        label = "borderColor"
    )

    val borderWidth by animateDpAsState(
        targetValue = if (isSelected) 3.dp else 2.dp,
        animationSpec = tween(durationMillis = 700),
        label = "borderWidth"
    )

    Card(
        modifier = Modifier
            .clickable(interactionSource = null, indication = null, onClick = { onSelect() })
            .padding(6.dp)
            .drawBehind {
                val borderWidthPx = borderWidth.toPx()
                drawRoundRect(
                    color = borderColor,
                    size = Size(size.width , size.height ),
                    cornerRadius = CornerRadius(12.dp.toPx()),
                    style = Stroke(width = borderWidthPx)
                )
            }
            .graphicsLayer {
                shape = RoundedCornerShape(12.dp)
                shadowElevation = elevation.value
                ambientShadowColor = Color(0xff153A78)
                spotShadowColor = Color(0xff153A78)
            },
        colors = CardDefaults.cardColors(Color.White)
    )
    {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            val density = LocalDensity.current
            AsyncImage(
                model = "https://firebasestorage.googleapis.com/v0/b/lmev-dev.appspot.com/o/Header%2FCity%2Fdelhi.png?alt=media&token=1ef0d3a8-531e-4e54-8cd8-38df81213e46",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer{
                        this.translationY = with(density) { translationY.toPx() }
                    }
            )
            Box {
                Box(
                    Modifier
                        .zIndex(1f)
                        .offset(y = (-15).dp)
                        .height(15.dp)
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.White.copy(alpha = 0.9f),
                                    Color.White
                                ),
                            )
                        )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 6.dp)
                        .heightIn(max = 28.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.White
                                )
                            )
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = isSelected,
                        onClick = onSelect,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xff526C92),
                            unselectedColor = Color(0xff526C92)
                        )
                    )
                    Text(
                        text = "Delhi NCR",
                        color = Color(0xff526C92),
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun PreviewCard(){
    EffectCard(
        isSelected = false,
        onSelect = {}
    )
}