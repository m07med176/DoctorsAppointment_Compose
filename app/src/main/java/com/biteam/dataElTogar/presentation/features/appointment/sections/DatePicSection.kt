package com.biteam.dataElTogar.presentation.features.appointment.sections

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.biteam.dataElTogar.presentation.components.CustomToggleButtonList
import com.biteam.dataElTogar.presentation.components.SeeAllWithTitle
import com.biteam.dataElTogar.presentation.utils.SimpleClick

@Composable
fun DatePicSection(onClick:SimpleClick) {
    SeeAllWithTitle(title = "Date", onClick = onClick)

    val dateList = listOf(
        "Sun 4","Mon 5","Tue 6","Wen 8","Thu 8"
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