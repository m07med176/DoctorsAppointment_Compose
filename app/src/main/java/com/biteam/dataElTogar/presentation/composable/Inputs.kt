package com.biteam.dataElTogar.presentation.composable

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
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

enum class TransformationType {
    SimpleText, Password, Date,CreditCard,ExpireDate
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldInput(
    value: String,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    leadingIcon: ImageVector? = null,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    transformation: TransformationType = TransformationType.SimpleText,
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
        visualTransformation =
        when (transformation) {
            TransformationType.SimpleText -> VisualTransformation.None
            TransformationType.Password -> PasswordVisualTransformation(mask = '*')
            TransformationType.Date -> visualTransformationDate()
            TransformationType.CreditCard -> visualTransformationCreditCard(value)
            TransformationType.ExpireDate -> visualTransformationExpireDate()
        },
        shape = RoundedCornerShape(size = 10.dp),
        modifier = modifier
            .border(
                width = 1.dp,
                color = SystemColor.textGray,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .height(60.dp)
            .background(color = SystemColor.backgroundGray)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        leadingIcon = if (leadingIcon != null) {
            {
                Icon(
                    imageVector = leadingIcon, contentDescription = null,
                    tint = SystemColor.textGray
                )
            }
        } else null,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = SystemColor.backgroundGray,
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
    uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true
)
@Composable
fun TextFieldInputPreview() {
    var textState by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(20.dp)) {
        TextFieldInput(value = textState, hint = "This is hint") {
            textState = it

        }

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldInput(value = textState, hint = "Write password") {
            textState = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldInput(
            value = textState,
            hint = "Write to search",
            leadingIcon = Icons.Default.Search
        ) {
            textState = it
        }
    }

}

private fun visualTransformationDate():VisualTransformation = VisualTransformation { text ->
    formatDate(text)
}
private fun visualTransformationExpireDate():VisualTransformation = VisualTransformation { text ->
    formatExpireDate(text)
}

fun formatDate(text: AnnotatedString): TransformedText {
    val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 2 == 1 && i < 4) out += "/"
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <= 3) return offset +1
            if (offset <= 8) return offset +2
            return 10
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <=2) return offset
            if (offset <=5) return offset -1
            if (offset <=10) return offset -2
            return 8
        }
    }

    return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}

fun formatExpireDate(text: AnnotatedString): TransformedText {
    val trimmed = if (text.text.length >= 4) text.text.substring(0..3) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i == 1 ) out += "/"
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset == 2) return offset + 1
            if (offset == 3) return offset + 1
            if (offset == 4) return offset + 1
            return offset
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset == 3) return offset - 1
            if (offset == 4) return offset - 1
            if (offset == 5) return offset - 1
            return offset
        }
    }

    return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}

private fun visualTransformationCreditCard(cardNumber:String):VisualTransformation = VisualTransformation { number ->
    when (identifyCardScheme(cardNumber)) {
        CardScheme.AMEX -> formatAmex(number)
        CardScheme.DINERS_CLUB -> formatDinnersClub(number)
        else -> formatOtherCardNumbers(number)
    }
}




// Credit Card Utils

enum class CardScheme {
    JCB, AMEX, DINERS_CLUB, VISA, MASTERCARD, DISCOVER, MAESTRO, UNKNOWN
}

fun identifyCardScheme(cardNumber: String): CardScheme {
    val jcbRegex = Regex("^(?:2131|1800|35)[0-9]{0,}$")
    val ameRegex = Regex("^3[47][0-9]{0,}\$")
    val dinersRegex = Regex("^3(?:0[0-59]{1}|[689])[0-9]{0,}\$")
    val visaRegex = Regex("^4[0-9]{0,}\$")
    val masterCardRegex = Regex("^(5[1-5]|222[1-9]|22[3-9]|2[3-6]|27[01]|2720)[0-9]{0,}\$")
    val maestroRegex = Regex("^(5[06789]|6)[0-9]{0,}\$")
    val discoverRegex =
        Regex("^(6011|65|64[4-9]|62212[6-9]|6221[3-9]|622[2-8]|6229[01]|62292[0-5])[0-9]{0,}\$")

    val trimmedCardNumber = cardNumber.replace(" ", "")

    return when {
        trimmedCardNumber.matches(jcbRegex) -> CardScheme.JCB
        trimmedCardNumber.matches(ameRegex) -> CardScheme.AMEX
        trimmedCardNumber.matches(dinersRegex) -> CardScheme.DINERS_CLUB
        trimmedCardNumber.matches(visaRegex) -> CardScheme.VISA
        trimmedCardNumber.matches(masterCardRegex) -> CardScheme.MASTERCARD
        trimmedCardNumber.matches(discoverRegex) -> CardScheme.DISCOVER
        trimmedCardNumber.matches(maestroRegex) -> if (cardNumber[0] == '5') CardScheme.MASTERCARD else CardScheme.MAESTRO
        else -> CardScheme.UNKNOWN
    }
}

fun formatAmex(text: AnnotatedString): TransformedText {
    val trimmed = if (text.text.length >= 15) text.text.substring(0..14) else text.text
    var out = ""

    for (i in trimmed.indices) {
        out += trimmed[i]
//        put - character at 3rd and 9th indicies
        if (i ==3 || i == 9 && i != 14) out += "-"
    }
//    original - 345678901234564
//    transformed - 3456-7890123-4564
//    xxxx-xxxxxx-xxxxx
    /**
     * The offset translator should ignore the hyphen characters, so conversion from
     *  original offset to transformed text works like
     *  - The 4th char of the original text is 5th char in the transformed text. (i.e original[4th] == transformed[5th]])
     *  - The 11th char of the original text is 13th char in the transformed text. (i.e original[11th] == transformed[13th])
     *  Similarly, the reverse conversion works like
     *  - The 5th char of the transformed text is 4th char in the original text. (i.e  transformed[5th] == original[4th] )
     *  - The 13th char of the transformed text is 11th char in the original text. (i.e transformed[13th] == original[11th])
     */
    val creditCardOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 3) return offset
            if (offset <= 9) return offset + 1
            if(offset <= 15) return offset + 2
            return 17
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 11) return offset - 1
            if(offset <= 17) return offset - 2
            return 15
        }
    }
    return TransformedText(AnnotatedString(out), creditCardOffsetTranslator)
}

fun formatDinnersClub(text: AnnotatedString): TransformedText{
    val trimmed = if (text.text.length >= 14) text.text.substring(0..13) else text.text
    var out = ""

    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i ==3 || i == 9 && i != 13) out += "-"
    }

//    xxxx-xxxxxx-xxxx
    val creditCardOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 3) return offset
            if (offset <= 9) return offset + 1
            if(offset <= 14) return offset + 2
            return 16
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 11) return offset - 1
            if(offset <= 16) return offset - 2
            return 14
        }
    }
    return TransformedText(AnnotatedString(out), creditCardOffsetTranslator)
}

fun formatOtherCardNumbers(text: AnnotatedString): TransformedText {

    val trimmed = if (text.text.length >= 16) text.text.substring(0..15) else text.text
    var out = ""

    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 4 == 3 && i != 15) out += "-"
    }
    val creditCardOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 3) return offset
            if (offset <= 7) return offset + 1
            if (offset <= 11) return offset + 2
            if (offset <= 16) return offset + 3
            return 19
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 9) return offset - 1
            if (offset <= 14) return offset - 2
            if (offset <= 19) return offset - 3
            return 16
        }
    }

    return TransformedText(AnnotatedString(out), creditCardOffsetTranslator)
}
