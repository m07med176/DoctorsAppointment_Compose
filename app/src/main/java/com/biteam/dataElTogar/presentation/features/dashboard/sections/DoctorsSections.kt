package com.biteam.dataElTogar.presentation.features.dashboard.sections

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biteam.dataElTogar.R
import com.biteam.dataElTogar.presentation.composable.SmallButton
import com.biteam.dataElTogar.presentation.composable.TextBody2
import com.biteam.dataElTogar.presentation.composable.TextHead3
import com.biteam.dataElTogar.presentation.features.dashboard.listContent.DoctorModel
import com.biteam.dataElTogar.presentation.features.dashboard.listContent.LazyDoctorItems
import com.biteam.dataElTogar.presentation.theme.SystemColor
import com.biteam.dataElTogar.presentation.theme.bodyMedium
import com.biteam.dataElTogar.presentation.theme.headlineSmall
import com.biteam.dataElTogar.presentation.utils.ClickBookItem

@Composable
fun DoctorsSection(seeAllDoctors:()-> Unit,onClickBookItem:ClickBookItem) {
        Spacer(modifier = Modifier.height(35.dp))
        Row {
            Text(text = "All Doctors", style = headlineSmall)
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = {seeAllDoctors()}) {
                Text(
                    text = "See All", style = bodyMedium, textAlign = TextAlign.Start
                )
            }


        }

        Spacer(modifier = Modifier.height(28.dp))

        LazyDoctorItems(modifier = Modifier.height(300.dp), onClickBookItem = onClickBookItem)

}

