package com.biteam.mohamed.presentation.features.payment

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.composable.MainButton
import com.biteam.mohamed.presentation.composable.TextFieldInput
import com.biteam.mohamed.presentation.composable.TransformationType
import com.biteam.mohamed.presentation.theme.SystemColor


object PaymentScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        PaymentContent(navigator)
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PaymentContent(navigator: Navigator?=null) {
    Column(
        modifier = Modifier
            .background(SystemColor.primary)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

            Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painterResource(id = R.drawable.back_ic),
                contentDescription = "Back",
                modifier = Modifier
                    .clickable {
                        navigator?.pop()
                    }
                    .size(50.dp)
                    .background(color = Color.White, shape = CircleShape)
                    .padding(15.dp)
            )
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth(0.9f)) {
                Text(
                    text = "Payment",
                    style = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight(700),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$120.00",
            style = TextStyle(
                fontSize = 56.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            )
        )

        Spacer(modifier = Modifier.height(57.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                )
                .padding(horizontal = 26.dp)
        ) {
            Spacer(modifier = Modifier.height(29.dp))
            Text(
                text = "Doctor Chanaling Payment Method",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = SystemColor.black,
                )
            )
            Spacer(modifier = Modifier.height(29.dp))

            var toggleState by remember {
                mutableStateOf(ToggleCashOption.CashPayment)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                CustomToggleButton(
                    title = "Card Payment",
                    currentToggleState = toggleState,
                    defaultToggleableState = ToggleCashOption.CardPayment,
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    toggleState = it
                }

                Spacer(modifier = Modifier.width(22.dp))

                CustomToggleButton(
                    title = "Cash Payment",
                    currentToggleState = toggleState,
                    defaultToggleableState = ToggleCashOption.CashPayment,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    toggleState = it
                }
            }

            Spacer(modifier = Modifier.height(29.dp))

            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "Card Number",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                )
            )

            Spacer(modifier = Modifier.height(15.dp))
            var cardNumberState by remember {
                mutableStateOf("")
            }
            TextFieldInput(
                value = cardNumberState,
                hint = "Enter Card Number",
                keyboardType = KeyboardType.Number,
                transformation = TransformationType.CreditCard
            ) {
                cardNumberState = it
            }



            Spacer(modifier = Modifier.height(25.dp))

            Row(modifier = Modifier.fillMaxWidth()) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Start),

                        text = "Expiry Date",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    var expiryDateState by remember {
                        mutableStateOf("")
                    }
                    TextFieldInput(
                        value = expiryDateState,
                        hint = "Enter Expiry Date",
                        transformation = TransformationType.ExpireDate,
                        keyboardType = KeyboardType.Number
                    ) {
                        expiryDateState = it
                    }


                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        modifier = Modifier.align(Alignment.Start),

                        text = "CVV",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    var cvvState by remember {
                        mutableStateOf("")
                    }
                    TextFieldInput(value = cvvState, hint = "CVV") {
                        cvvState = it
                    }
                }


            }


            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Name",
                modifier = Modifier.align(Alignment.Start),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    color = SystemColor.black,
                )
            )
            Spacer(modifier = Modifier.height(15.dp))

            var nameState by remember {
                mutableStateOf("")
            }
            TextFieldInput(value = nameState, hint = "Enter Name") { nameState = it }

            Spacer(modifier = Modifier.height(40.dp))

            MainButton(title = "Pay Now", modifier = Modifier.fillMaxWidth()) {
                navigator?.push(PaymentSuccessfullyScreen)
            }

            Spacer(modifier = Modifier.height(10.dp))

        }
    }

}

enum class ToggleCashOption {
    CashPayment, CardPayment, Nothing
}

@Composable
fun CustomToggleButton(
    title: String,
    defaultToggleableState: ToggleCashOption,
    currentToggleState: ToggleCashOption,
    modifier: Modifier = Modifier,
    onClickButton: (ToggleCashOption) -> Unit
) {
    Button(
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = SystemColor.backgroundGray,
            contentColor = Color.Black,
            disabledBackgroundColor = SystemColor.primary,
            disabledContentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(0.dp),
        enabled = defaultToggleableState != currentToggleState,
        onClick = { onClickButton(defaultToggleableState) }) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
            )
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "Arabic",
    locale = "ar",
    device = Devices.PIXEL_3A_XL,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "English",
    locale = "en",
    device = Devices.PIXEL_3A_XL,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PaymentPreview() {
    PaymentContent()
}