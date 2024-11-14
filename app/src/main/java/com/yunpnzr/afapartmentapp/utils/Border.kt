package com.yunpnzr.afapartmentapp.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun Modifier.bottomBorder(
    strokeWidth: Dp,
    color: Color,
): Modifier = this.then(
    Modifier.drawBehind {
        drawLine(
            color = color,
            strokeWidth = strokeWidth.toPx(),
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height)
        )
    }
)