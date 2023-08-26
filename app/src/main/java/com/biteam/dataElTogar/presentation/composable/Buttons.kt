package com.biteam.dataElTogar.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biteam.dataElTogar.presentation.theme.SystemColor
import com.biteam.dataElTogar.presentation.utils.SimpleClick


@Composable
fun MainButton(title:String,modifier: Modifier = Modifier,onClick:SimpleClick) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(size = 10.dp),
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = SystemColor.primary),
    ) {
        Text(text = title,
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(700),
                color = Color.White,
                textAlign = TextAlign.Center,
            ))
    }
}

@Composable
fun SmallButton(title:String,modifier: Modifier = Modifier,onClick:SimpleClick) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(size = 20.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = SystemColor.primary),
    ) {
        Text(text = title, style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight(400),
            color = Color.White,
        )
        )
    }
}

@Preview
@Composable
fun ButtonsPreview() {
    Column {
        MainButton(title = "Test Button"){

        }

        SmallButton(title = "Small Button"){

        }
    }
}