package com.biteam.dataElTogar.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),



)
val titleSmall = TextStyle(
    fontSize = 18.sp,
    lineHeight = 18.sp,
    fontWeight = FontWeight(600),
    color = Color(0xFF000000),
)
val  headlineSmall = TextStyle(
    fontSize = 22.sp,
    lineHeight = 22.sp,
    fontWeight = FontWeight(600),
    color = Color(0xFF000000),
    textAlign = TextAlign.Center,
)

val bodyMedium = TextStyle(
    fontSize = 18.sp,
    lineHeight = 18.sp,
    fontWeight = FontWeight(400),
    color = Color(0xFF858585),
)
val headlineMedium =  TextStyle(
fontSize = 26.sp,
lineHeight = 26.sp,
fontWeight = FontWeight(700),
color = Color(0xFF000000),
textAlign = TextAlign.Center,
)

val titleLarge = TextStyle(
fontSize = 26.sp,
lineHeight = 26.sp,
fontWeight = FontWeight(700),
color = SystemColor.primary,
textAlign = TextAlign.Center,
)

val headlineLarge = TextStyle(
fontSize = 70.sp,
lineHeight = 70.sp,
fontWeight = FontWeight(600),
    color = SystemColor.primary,
)