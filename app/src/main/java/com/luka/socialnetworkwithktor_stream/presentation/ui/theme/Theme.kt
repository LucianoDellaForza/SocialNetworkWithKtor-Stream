package com.luka.socialnetworkwithktor_stream.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
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