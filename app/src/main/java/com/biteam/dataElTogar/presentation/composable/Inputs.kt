package com.biteam.dataElTogar.presentation.composable

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biteam.dataElTogar.presentation.theme.SystemColor
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
fun TextFieldInput(
    value: String,
    hint: String,
    visual: Char? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    leadingIcon: ImageVector? = null,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(
                text = hint,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(400),
                    color = SystemColor.textGray,
                    textAlign = TextAlign.Start,
                )
            )
        },
        singleLine = true,
        maxLines = 1,
        visualTransformation = if (visual == null) VisualTransformation.None else PasswordVisualTransformation(
            mask = visual
        ),
        shape = RoundedCornerShape(size = 10.dp),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = SystemColor.textGray,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .fillMaxWidth()
            .height(60.dp)
            .background(color = SystemColor.backgroundGray),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    imageVector = leadingIcon, contentDescription = null,
                    tint = Color(0xFF999999)
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            cursorColor = Color.Red,
            textColor = Color.Black,
            placeholderColor = Color.Black,
            disabledTextColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            disabledLabelColor = Color.Black,
            errorCursorColor = Color.Red,
            errorLabelColor = Color.Red,

            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,


            ),
    )
}


@Preview(
    name = "English",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TextFieldInputPreview() {
    var textState by remember { mutableStateOf("") }

    Column {
        TextFieldInput(value = textState, hint = "This is hint") {
            textState = it

        }

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldInput(value = textState, hint ="Write password", visual = '*') {
            textState = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldInput(value = textState, hint ="Write to search", leadingIcon = Icons.Default.Search) {
            textState = it
        }
    }

}