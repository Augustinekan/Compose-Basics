package com.example.composebasics.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
val  primaryVariantBlue = Color(0xff669ac7);
val greenCustom = Color(0xff59673d)
private val DarkColorPalette = darkColors(
    primary = Color(0xff1c63a3),
    primaryVariant = primaryVariantBlue,
    secondary = Teal200,
    //surface = greenCustom,
    onPrimary = Color.White
)

private val LightColorPalette = lightColors(
    primary = primaryVariantBlue,
    primaryVariant = primaryVariantBlue,
    secondary = Teal200,
   // surface = greenCustom,
    onPrimary = Color.White
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ComposeBasicsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}