package com.biteam.mohamed.presentation.features.appointment

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.biteam.mohamed.presentation.components.CustomAppBar
import com.biteam.mohamed.presentation.composable.MainButton
import com.biteam.mohamed.presentation.features.dashboard.listContent.DoctorModel
import com.biteam.mohamed.presentation.features.appointment.sections.DatePicSection
import com.biteam.mohamed.presentation.features.appointment.sections.DetailsDoctorSection
import com.biteam.mohamed.presentation.features.appointment.sections.DoctorContactSection
import com.biteam.mohamed.presentation.features.appointment.sections.WorkerHoursSection
import com.biteam.mohamed.presentation.features.chat.AudioCallScreen
import com.biteam.mohamed.presentation.features.chat.ChatRoomScreen
import com.biteam.mohamed.presentation.features.chat.MessageModel
import com.biteam.mohamed.presentation.features.chat.VideoCallScreen
import com.biteam.mohamed.presentation.features.payment.PaymentScreen
import com.biteam.mohamed.presentation.utils.SimpleClick

data class DoctorDetailsScreenActions(
    val onBackClick: SimpleClick,
    val onClickChat: SimpleClick,
    val onClickVideoCall: SimpleClick,
    val onClickVoiceCall: SimpleClick,
    val onClickAppointment: SimpleClick,
)

data class DoctorDetailsScreen(private val doctorModel: DoctorModel) : Screen {


    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val actions = DoctorDetailsScreenActions(
            onClickVoiceCall = {
                navigator.push(
                    AudioCallScreen(
                        MessageModel(
                            thumbnail = doctorModel.thumbnail,
                            name = doctorModel.name,
                            lastMessage = "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",
                            lastTime = "10:30"
                        )
                    )
                )
            },
            onClickVideoCall = {
                navigator.push(VideoCallScreen(
                    MessageModel(
                        thumbnail = doctorModel.thumbnail,
                        name = doctorModel.name,
                        lastMessage = "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",
                        lastTime = "10:30"
                    )
                ))
            },
            onClickChat = {
                navigator.push(ChatRoomScreen(
                    MessageModel(
                        thumbnail = doctorModel.thumbnail,
                        name = doctorModel.name,
                        lastMessage = "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",
                        lastTime = "10:30"
                    )
                ))
            },
            onBackClick = {
                navigator.pop()
            },
            onClickAppointment = {
                navigator.push(PaymentScreen)
            }
        )

        DoctorDetailsContent(actions, doctorModel)
    }

}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DoctorDetailsContent(
    actions: DoctorDetailsScreenActions,
    doctorModel: DoctorModel
) {
    Scaffold(topBar = {
        CustomAppBar(title = "Appointment") {
            actions.onBackClick()
        }
    })
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 26.dp, end = 26.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(37.dp))
            DoctorContactSection(
                onClickChat = actions.onClickChat,
                onClickVideoCall = actions.onClickVideoCall,
                onClickVoiceCall = actions.onClickVoiceCall, doctorModel
            )
            Spacer(modifier = Modifier.height(45.dp))
            DetailsDoctorSection()
            Spacer(modifier = Modifier.height(45.dp))
            WorkerHoursSection {

            }
            DatePicSection {

            }

            Spacer(modifier = Modifier.weight(1f))

            MainButton(title = "Book an Appointment", modifier = Modifier.fillMaxWidth()) {
                actions.onClickAppointment()
            }

            Spacer(modifier = Modifier.height(25.dp))
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
fun DoctorDetailsPreview() {
    val actions = DoctorDetailsScreenActions(
        onClickVoiceCall = {},
        onClickVideoCall = {},
        onClickChat = {},
        onBackClick = {},
        onClickAppointment = {}
    )
    DoctorDetailsContent(actions, doctorModel = DoctorModel(thumbnail = ""))
}

