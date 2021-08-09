package com.luka.socialnetworkwithktor_stream.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = GreenAccent,
    onPrimary = DarkGray,
    background = DarkGray,
    onBackground = TextWhite,
    surface = MediumGray,
    onSurface = LightGray
)

@Composable
fun SocialNetworkWithKtorStreamTheme(
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}