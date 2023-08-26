package com.biteam.mohamed.presentation.features.appointment.sections

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.biteam.mohamed.presentation.components.CustomToggleButtonList
import com.biteam.mohamed.presentation.components.SeeAllWithTitle
import com.biteam.mohamed.presentation.utils.SimpleClick

@Composable
fun WorkerHoursSection(title:String = "Working Hours",onClick:SimpleClick) {
    SeeAllWithTitle(title = title, onClick = onClick)

    val dateList = listOf(
        "10.00 AM","11.00 AM","12.00 PM","12.30 PM","01.30 PM"
    )
    var selectedItem by remember {
        mutableStateOf(dateList[0])
    }
    LazyRow{

        items(dateList){
            CustomToggleButtonList(
                title = it,
                currentToggleState = selectedItem,
                modifier = Modifier.padding(end = 7.dp)
            ){
                selectedItem = it
            }
        }
    }

}