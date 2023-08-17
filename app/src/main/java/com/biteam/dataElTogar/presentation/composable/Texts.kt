package com.biteam.dataElTogar.presentation.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

val styleBody3 = TextStyle(
    fontSize = 14.sp,
    lineHeight = 16.sp,
    fontWeight = FontWeight(400),
    color = Color(0xFF858585),
    letterSpacing = 0.4.sp,
)

val styleHead3 = TextStyle(
    fontSize = 18.sp,
    lineHeight = 24.sp,
    fontWeight = FontWeight(600),
    color = Color.Black,
    letterSpacing = 0.1.sp,
)

@Composable
fun TextBody2(text: String,modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = styleBody3,
        modifier = modifier
    )
}

@Composable
fun TextHead3(text:String,modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = styleHead3,
        modifier = modifier
    )
}