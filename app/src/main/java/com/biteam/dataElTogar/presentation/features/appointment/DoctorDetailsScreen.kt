package com.biteam.dataElTogar.presentation.features.appointment

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.biteam.dataElTogar.R
import com.biteam.dataElTogar.presentation.components.CustomAppBar
import com.biteam.dataElTogar.presentation.composable.MainButton
import com.biteam.dataElTogar.presentation.composable.TextHead1
import com.biteam.dataElTogar.presentation.features.dashboard.listContent.DoctorModel
import com.biteam.dataElTogar.presentation.features.appointment.sections.DatePicSection
import com.biteam.dataElTogar.presentation.features.appointment.sections.DetailsDoctorSection
import com.biteam.dataElTogar.presentation.features.appointment.sections.DoctorContactSection
import com.biteam.dataElTogar.presentation.features.appointment.sections.WorkerHoursSection
import com.biteam.dataElTogar.presentation.utils.SimpleClick

data class DoctorDetailsScreenActions(
    val onBackClick: SimpleClick,
    val onClickChat: SimpleClick,
    val onClickVideoCall: SimpleClick,
    val onClickVoiceCall: SimpleClick
)

data class DoctorDetailsScreen(private val doctorModel: DoctorModel) : Screen {


    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val actions = DoctorDetailsScreenActions(
            onClickVoiceCall = ::onClickVoiceCall,
            onClickVideoCall = ::onClickVideoCall,
            onClickChat = ::onClickChat,
            onBackClick = {
                navigator.pop()
            }
        )

        DoctorDetailsContent(actions)
    }

    private fun onClickVoiceCall() {

    }

    private fun onClickVideoCall() {

    }

    private fun onClickChat() {

    }


}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DoctorDetailsContent(actions: DoctorDetailsScreenActions) {
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
                onClickVoiceCall = actions.onClickVoiceCall
            )
            Spacer(modifier = Modifier.height(45.dp))
            DetailsDoctorSection()
            Spacer(modifier = Modifier.height(45.dp))
            WorkerHoursSection{

            }
            DatePicSection{

            }

            Spacer(modifier = Modifier.weight(1f))

            MainButton(title = "Book an Appointment", modifier = Modifier.fillMaxWidth()) {

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
        onBackClick = {}
    )
    DoctorDetailsContent(actions)
}
