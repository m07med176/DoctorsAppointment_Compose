package com.biteam.mohamed.presentation.features.dashboard

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.composable.NAVIGATION_HEIGHT
import com.biteam.mohamed.presentation.features.appointment.AppointmentScreen
import com.biteam.mohamed.presentation.features.appointment.DoctorDetailsScreen
import com.biteam.mohamed.presentation.features.dashboard.sections.AdsSection
import com.biteam.mohamed.presentation.features.dashboard.sections.CategorySection
import com.biteam.mohamed.presentation.features.dashboard.sections.DoctorsSection
import com.biteam.mohamed.presentation.features.dashboard.sections.SearchSection
import com.biteam.mohamed.presentation.features.dashboard.sections.TopSection
import com.biteam.mohamed.presentation.utils.ClickBookItem


object DashboardScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(id = R.drawable.home_tap)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Home",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        DashboardContent(
            onClickSeeAllDoctorSection = {
                navigator.push(AppointmentScreen)
             },
            onClickBookItem = {
                navigator.parent?.push(DoctorDetailsScreen(doctorModel = it))
        })
    }
}


@Composable
fun DashboardContent(onClickSeeAllDoctorSection: () -> Unit, onClickBookItem: ClickBookItem) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 26.dp, end = 26.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopSection()
        SearchSection(title = "Search a Doctor"){

        }
        AdsSection()
        CategorySection()
        DoctorsSection(seeAllDoctors = {
            onClickSeeAllDoctorSection()

        }, onClickBookItem = onClickBookItem)
    }
    Spacer(modifier = Modifier.height(120.dp))
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
fun DashboardPreview() {
    DashboardContent(
        onClickSeeAllDoctorSection = {
        },
        onClickBookItem = {
        })

}