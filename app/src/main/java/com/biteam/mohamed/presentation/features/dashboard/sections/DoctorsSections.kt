package com.biteam.mohamed.presentation.features.dashboard.sections

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.biteam.mohamed.presentation.components.SeeAllWithTitle
import com.biteam.mohamed.presentation.features.dashboard.listContent.LazyDoctorItems
import com.biteam.mohamed.presentation.utils.ClickBookItem

@Composable
fun DoctorsSection(seeAllDoctors: () -> Unit, onClickBookItem: ClickBookItem) {
    Spacer(modifier = Modifier.height(35.dp))

    SeeAllWithTitle("All Doctors") {

    }
    Spacer(modifier = Modifier.height(28.dp))

    LazyDoctorItems(modifier = Modifier.height(300.dp), onClickBookItem = onClickBookItem)

}

