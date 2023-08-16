package com.biteam.dataElTogar.presentation.features.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.biteam.dataElTogar.R


object ProfileScreen: Tab {

    override val options: TabOptions
        @Composable
        get(){
            val icon = painterResource(id = R.drawable.profile_tap)

            return remember {
                TabOptions(
                    index = 3u,
                    title = "Profile",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "ViewMapScreen")
    }
}