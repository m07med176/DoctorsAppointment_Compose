package com.biteam.mohamed.presentation.features.authentication

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.biteam.mohamed.presentation.composable.Input
import com.biteam.mohamed.presentation.composable.MainButton
import com.biteam.mohamed.presentation.composable.TextHead1
import com.biteam.mohamed.presentation.composable.TransformationType
import com.biteam.mohamed.presentation.features.HomeScreen
import com.biteam.mohamed.presentation.theme.SystemColor

object RegisterScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        RegisterContent(navigator)


    }
}

@Composable
fun RegisterContent(navigator: Navigator? = null) {
    LazyColumn(

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {

            Spacer(modifier = Modifier.height(29.dp))
            TextHead1(text = stringResource(R.string.create_new_account))

            Spacer(modifier = Modifier.height(37.dp))
            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(24.dp)) {

                var nameState by remember{
                    mutableStateOf("")
                }
                Input(
                    title = stringResource(R.string.fullname),
                    value = nameState,
                    hint = stringResource(R.string.enter_your_email)
                ) {
                    nameState = it
                }

                Spacer(modifier = Modifier.height(20.dp))

                var emailState by remember{
                    mutableStateOf("")
                }
                Input(
                    title = stringResource(R.string.email),
                    value = emailState,
                    hint = stringResource(R.string.enter_your_email)
                ) {
                    emailState = it
                }

                Spacer(modifier = Modifier.height(20.dp))

                var passwordState by remember{
                    mutableStateOf("")
                }
                Input(
                    title = stringResource(R.string.password),
                    value = passwordState,
                    hint = stringResource(R.string.enter_your_password),
                    transformation = TransformationType.Password
                ) {
                    passwordState= it
                }

                Spacer(modifier = Modifier.height(20.dp))
                var mobileState by remember{
                    mutableStateOf("")
                }
                Input(
                    title = stringResource(R.string.mobile_number),
                    value = mobileState,
                    keyboardType = KeyboardType.Phone,
                    hint = stringResource(R.string.enter_your_mobile_number)
                ) {
                    mobileState = it
                }



                Spacer(modifier = Modifier.height(30.dp))
                MainButton(title = stringResource(R.string.sign_up), modifier = Modifier.fillMaxWidth()) {
                    navigator?.push(HomeScreen)
                }

                Spacer(modifier = Modifier.height(10.dp))



                Spacer(modifier = Modifier.height(29.dp))
                Text(
                    text = stringResource(R.string.or),
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 22.sp,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF858585),
                        textAlign = TextAlign.Center,
                    )
                )

                Spacer(modifier = Modifier.height(19.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook_icon),
                        contentDescription = "facebook_icon",
                        modifier = Modifier
                            .border(width = 1.dp, color = Color(0xFFD2EBE7), shape = CircleShape)
                            .padding(10.dp)
                            .width(40.dp)
                            .height(40.dp)
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Image(
                        painter = painterResource(id = R.drawable.google_icon),
                        contentDescription = "facebook_icon",
                        modifier = Modifier
                            .border(width = 1.dp, color = Color(0xFFD2EBE7), shape = CircleShape)
                            .padding(10.dp)
                            .width(40.dp)
                            .height(40.dp)
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.don_t_have_an_account),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = SystemColor.black,
                        )
                    )
                    TextButton(onClick = {
                        navigator?.push(LoginScreen)
                    }) {
                        Text(
                            text = stringResource(R.string.sign_in),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(600),
                                color = SystemColor.primary,
                            )
                        )
                    }
                }

            }
        }
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
fun RegisterPreview() {
    RegisterContent()
}