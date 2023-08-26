@file:OptIn(ExperimentalMaterial3Api::class)

package com.biteam.dataElTogar.presentation.features.chat

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.biteam.dataElTogar.presentation.components.CustomAppBar
import com.biteam.dataElTogar.presentation.composable.TextFieldInput
import com.biteam.dataElTogar.presentation.composable.TextHead1
import com.biteam.dataElTogar.presentation.features.appointment.sections.ButtonImageHolderDoctorProfile
import com.biteam.dataElTogar.presentation.theme.SystemColor


data class ChatRoomScreen(val name: String, val id: Int) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ChatRoomContent(name, id, navigator)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChatRoomContent(name: String, id: Int, navigator: Navigator? = null) {

    Scaffold(topBar = {

        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            modifier = Modifier
        ) {

            IconButton(onClick = {
                navigator?.pop()
            }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.back_ic),
                    contentDescription = null
                )
            }

            Box(modifier = Modifier.weight(0.8f), contentAlignment = Alignment.Center) {
                TextHead1(text = name )
            }

            ButtonImageHolderDoctorProfile(
                R.drawable.voice_call_ic,
                simpleClick = {
                    navigator?.push(AudioCallScreen(name))

                }
            )
            Spacer(modifier = Modifier.width(15.dp))
            ButtonImageHolderDoctorProfile(
                R.drawable.video_call_ic,
                simpleClick = {
                    navigator?.push(VideoCallScreen(name))
                }
            )
            Spacer(modifier = Modifier.width(25.dp))
        }

    }) {
        val messages = listOf(
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = false),
            Message(content = "Rorem ipsum dolor sit  adipiscing elit.", isYouSender = true),

            )
        Box {

            Column(modifier = Modifier.fillMaxHeight()) {
                Spacer(modifier = Modifier.height(60.dp))
                LazyColumn(modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .padding(horizontal = 26.dp)) {
                    items(messages) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Box(

                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .wrapContentWidth()
                                    .height(45.dp)
                                    .background(
                                        color = if (it.isYouSender) SystemColor.primary else SystemColor.backgroundGray,
                                        shape = RoundedCornerShape(size = 8.dp)
                                    )
                                    .align(if (it.isYouSender) Alignment.End else Alignment.Start),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = it.content,
                                    modifier = Modifier.padding(
                                        vertical = 5.dp,
                                        horizontal = 10.dp
                                    ),
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 14.sp,
                                        fontWeight = FontWeight(400),
                                        color = if (it.isYouSender) Color.White else Color.Black,
                                        textAlign = TextAlign.Center,
                                    )
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(80.dp))
            }

            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                var message by remember {
                    mutableStateOf("")
                }
                Row(modifier = Modifier.padding(10.dp)) {
                    TextFieldInput(

                        leadingIcon = Icons.Outlined.Person,
                        value = message,
                        hint = "Write here",
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .align(Alignment.Bottom)
                            .padding(end = 13.dp)) {
                        message = it
                    }
                    Column {
                        Image(
                            modifier = Modifier
                                .size(50.dp)
                                .background(SystemColor.primary, shape = CircleShape)
                                .padding(10.dp),
                            painter = painterResource(id = R.drawable.phone_ic),
                            contentDescription = "image description",
                            contentScale = ContentScale.None
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(
                            modifier = Modifier
                                .size(50.dp)
                                .background(SystemColor.primary, shape = CircleShape)
                                .padding(10.dp),
                            painter = painterResource(id = R.drawable.send_ic),
                            contentDescription = "image description",
                            contentScale = ContentScale.None
                        )
                    }
                }
            }
        }

    }

}

data class Message(
    val content: String, val isYouSender: Boolean, val datetime: Long? = null
)

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
fun ChatRoomPreview() {

    ChatRoomContent("Moahmed", 8)
}