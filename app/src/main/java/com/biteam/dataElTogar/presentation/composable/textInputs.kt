package com.biteam.dataElTogar.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biteam.dataElTogar.presentation.theme.headlineSmall

@Composable
fun Input(title: String, value: String, hint: String, onValueChange: () -> Unit) {
    Text(text = title, style = headlineSmall)
    Spacer(modifier = Modifier.height(18.dp))
    TextFieldInput(value, hint) {
        onValueChange()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldInput(value: String, hint: String, onValueChange: () -> Unit) {
    TextField(
        value = value,
        onValueChange = { onValueChange() },
        placeholder = {
            Text(
                text = hint,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF858585),
                    textAlign = TextAlign.Start,
                )
            )
        },
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0x4D858585),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .width(376.55298.dp)
            .height(60.dp)
            .background(color = Color(0x4DD9D9D9), shape = RoundedCornerShape(size = 10.dp)),

        )
}