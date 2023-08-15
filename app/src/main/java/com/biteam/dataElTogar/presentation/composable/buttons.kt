package com.biteam.dataElTogar.presentation.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.biteam.dataElTogar.presentation.MainActivity
import com.biteam.dataElTogar.presentation.features.HomeScreen
import com.biteam.dataElTogar.presentation.theme.primary


@Composable
fun MainButton(title:String,onClick:()->Unit) {
    Button(
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(size = 10.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = primary),
    ) {
        Text(text = title)
    }
}