package com.martin.newpralala

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun CardItem(isSelected: Boolean, onSelect: () -> Unit){
    val elevation by rememberUpdatedState(
        animateDpAsState(
            targetValue = if (isSelected) 16.dp else 0.dp,
            animationSpec = tween(durationMillis = 700),
            label = "cardElevation"
        ).value
    )

    val translationY by rememberUpdatedState(
        animateDpAsState(
            targetValue = if (isSelected) (-8).dp else 0.dp,
            animationSpec = tween(durationMillis = 700),
            label = "imageTranslation"
        ).value
    )

    val borderColor by rememberUpdatedState(
        animateColorAsState(
            targetValue = if (isSelected) Color(0xffB9CDF5) else Color(0xffDAE3F2),
            animationSpec = tween(durationMillis = 700),
            label = "borderColor"
        ).value
    )

    val borderWidth by rememberUpdatedState(
        animateDpAsState(
            targetValue = if (isSelected) 2.dp else 1.dp,
            animationSpec = tween(durationMillis = 700),
            label = "borderWidth"
        ).value
    )


    Card(
        modifier = Modifier
            .clickable(interactionSource = null, indication = null, onClick = { onSelect() })
            .padding(6.dp)
            .border(width = borderWidth, color = borderColor, shape = RoundedCornerShape(12.dp))
            .graphicsLayer(
                shape = RoundedCornerShape(12.dp),
                shadowElevation = elevation.value,
                ambientShadowColor = Color(0xff153A78),
                spotShadowColor = Color(0xff153A78)
            ),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        val density = LocalDensity.current
        AsyncImage(
            model = "https://firebasestorage.googleapis.com/v0/b/lmev-dev.appspot.com/o/Header%2FCity%2Fdelhi.png?alt=media&token=1ef0d3a8-531e-4e54-8cd8-38df81213e46",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer(
                    translationY = with(density) { translationY.toPx() }
                ),
        )

    }

}