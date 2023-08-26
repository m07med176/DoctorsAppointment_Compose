package com.biteam.dataElTogar.presentation.features.chat

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.biteam.dataElTogar.R
import com.biteam.dataElTogar.presentation.theme.SystemColor


data class AudioCallScreen(val name: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        AudioCallContent(name, navigator)
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AudioCallContent(name: String, navigator: Navigator? = null) {

    val gradient = Brush.verticalGradient(
        0.0f to SystemColor.secondary, 1.0f to Color(0xFFC0F9F0), startY = 0.0f, endY = 1000.0f
    )
    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxHeight()
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Card(
                shape = CircleShape,
                modifier = Modifier
                    .size(150.dp)
                    .border(width = 3.dp, color = Color.White, shape = CircleShape)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.doctor_profile_imags),
                    contentDescription = null
                )


            }

            Spacer(modifier = Modifier.height(29.dp))

            Text(
                text = name, style = TextStyle(
                    fontSize = 30.sp,
                    lineHeight = 30.sp,
                    fontWeight = FontWeight(700),
                    color = SystemColor.black,
                    textAlign = TextAlign.Center,
                )
            )

            Spacer(modifier = Modifier.height(29.dp))
            Text(
                text = "Ringing", style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(400),
                    color = SystemColor.black,
                    textAlign = TextAlign.Center,
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(modifier = Modifier
                    .clickable {
                        navigator?.push(VideoCallScreen(name))
                    }
                    .size(50.dp)
                    .padding(horizontal = 5.dp)
                    .background(Color.White, shape = CircleShape)
                    .padding(10.dp),
                    colorFilter = ColorFilter.tint(Color.Black),
                    painter = painterResource(id = R.drawable.video_call_ic),
                    contentDescription = "image description",
                    contentScale = ContentScale.None)
                Image(modifier = Modifier
                    .clickable {
                        navigator?.pop()
                    }
                    .size(50.dp)
                    .padding(horizontal = 5.dp)
                    .background(Color.Red, shape = CircleShape)
                    .padding(10.dp),
                    painter = painterResource(id = R.drawable.voice_call_ic),
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = "image description",
                    contentScale = ContentScale.None)
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(horizontal = 5.dp)
                        .background(SystemColor.primary, shape = CircleShape)
                        .padding(10.dp),
                    painter = painterResource(id = R.drawable.phone_ic),
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
            Spacer(
                modifier = Modifier.height(
                    100.dp
                )
            )
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
fun AudioCallPreview() {
    AudioCallContent("mohamed")
}