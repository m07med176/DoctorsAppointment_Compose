package com.biteam.dataElTogar.presentation.features.dashboard.sections

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.biteam.dataElTogar.R
import com.biteam.dataElTogar.presentation.theme.SystemColor
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun AdsSection() {
    val pagerState = rememberPagerState()

    val scope = rememberCoroutineScope()

    Spacer(modifier = Modifier.height(45.dp))

    val imagesList = listOf(
        R.drawable.ads_1,
        R.drawable.ads_2,
        R.drawable.ads_3,
        R.drawable.ads_4,
    )
    HorizontalPager(count = imagesList.size, state = pagerState) { index ->
        Image(
            painter = painterResource(id = imagesList[index]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(169.dp)
                .background(color = SystemColor.primary, shape = RoundedCornerShape(size = 10.dp))
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    Row(horizontalArrangement = Arrangement.Center) {

        imagesList.forEach {
            IconToggleButton(
                checked = pagerState.currentPage == it, onCheckedChange = {},
                modifier = Modifier
                    .padding(1.dp)
                    .size(10.dp)
                    .background(
                        color = if (pagerState.currentPage == it) SystemColor.primary else SystemColor.backgroundGray,
                        shape = CircleShape
                    )
                    .padding(7.dp)
            ) {

            }
        }


    }
    /*
        scope.launch {
        var index = 0
        while (true) {

            delay(2000)
            pagerState.scrollToPage(index)
            index++
            if (index == imagesList.size) {
                index = 0
            }

        }
    }
     */

}

