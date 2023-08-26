package com.biteam.dataElTogar.presentation.features.dashboard.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.biteam.dataElTogar.presentation.composable.TextFieldInput

@Composable
fun SearchSection(title:String,modifier: Modifier = Modifier,onUserTyping:(String)->Unit) {
    var textState by remember {
        mutableStateOf("")
    }
    Spacer(modifier = modifier.height(30.dp))
    Box {
        TextFieldInput(
            value = textState,
            hint = title,
            leadingIcon = Icons.Default.Search
        ) {
            textState = it
            onUserTyping(textState)
        }
    }
}