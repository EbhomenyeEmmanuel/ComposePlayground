package com.emma.composeplayground.common.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun PagerDotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    selectedColor: Color = Color.Black,
    unSelectedColor: Color = Color.Gray
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(totalDots) { index ->
            val isSelected = index == selectedIndex

            val size by animateDpAsState(targetValue = if (isSelected) 12.dp else 8.dp)
            val color by animateColorAsState(targetValue = if (isSelected) selectedColor else unSelectedColor)

            Surface(
                modifier = Modifier
                    .padding(4.dp)
                    .size(size),
                shape = CircleShape,
                color = color
            ) {}
        }
    }
}
