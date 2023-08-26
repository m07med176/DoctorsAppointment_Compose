package com.biteam.mohamed.presentation.features.appointment

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.features.dashboard.DoctorsContent

object AppointmentScreen: Tab {

    override val options: TabOptions
        @Composable
        get(){
            val icon = painterResource(id = R.drawable.appointment_tap)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Booking",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        DoctorsContent(
            onClickBackBtn = { navigator.pop() },
            onClickDoctorModel = {
                navigator.parent?.push(DoctorDetailsScreen(it))
            })
    }
}