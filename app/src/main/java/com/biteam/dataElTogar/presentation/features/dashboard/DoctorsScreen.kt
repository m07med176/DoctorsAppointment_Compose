package com.biteam.dataElTogar.presentation.features.dashboard

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.biteam.dataElTogar.presentation.composable.TextHead1
import com.biteam.dataElTogar.presentation.features.appointment.DoctorDetailsScreen
import com.biteam.dataElTogar.presentation.features.dashboard.listContent.LazyDoctorItems
import com.biteam.dataElTogar.presentation.features.dashboard.sections.SearchSection
import com.biteam.dataElTogar.presentation.utils.ClickBookItem
import com.biteam.dataElTogar.presentation.utils.SimpleClick


object DoctorsScreen : Screen {
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


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DoctorsContent(onClickBackBtn: SimpleClick, onClickDoctorModel: ClickBookItem) {
    Scaffold(
        topBar = {
            CustomAppBar(title = "All Doctors") {
                onClickBackBtn()
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

            Spacer(modifier = Modifier.height(21.dp))
            SearchSection(title = "Search A Doctor"){

            }
            Spacer(modifier = Modifier.height(30.dp))
            LazyDoctorItems(modifier = Modifier.weight(1f), onClickBookItem = onClickDoctorModel)

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
fun DoctorsPreview() {
    DoctorsContent(onClickBackBtn = {}, onClickDoctorModel = {})
}