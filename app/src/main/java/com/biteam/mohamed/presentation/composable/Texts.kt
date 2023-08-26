package com.biteam.mohamed.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.biteam.mohamed.presentation.theme.titleLarge
import com.biteam.mohamed.presentation.theme.titleSmall

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
fun TextBody2(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = styleBody3,
        modifier = modifier
    )
}

@Composable
fun TextHead3(text: String, modifier: Modifier = Modifier,color:Color = Color.Black) {
    Text(
        text = text,
        style = styleHead3,
        modifier = modifier,
        color = color
    )
}

@Composable
fun TextHead4(text: String, modifier: Modifier = Modifier, color: Color = Color.Black) {
    Text(
        text = text,
        style = titleSmall,
        modifier = modifier,
        textAlign = TextAlign.Start,
        color = color
    )
}

@Composable
fun TextHead1(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = titleLarge
    )
}

@Preview
@Composable
fun TextPreview() {
    Column {
        TextHead1(text = "TextHead1")
    }
}