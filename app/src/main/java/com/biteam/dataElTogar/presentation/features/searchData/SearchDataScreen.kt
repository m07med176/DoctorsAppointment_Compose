package com.biteam.dataElTogar.presentation.features.searchData

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions


object SearchDataScreen: Tab {

    override val options: TabOptions
        @Composable
        get(){
            val icon = rememberVectorPainter(Icons.Default.Search)

            return remember {
                TabOptions(
                    index = 3u,
                    title = "Search Togar",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "ViewMapScreen")
    }
}