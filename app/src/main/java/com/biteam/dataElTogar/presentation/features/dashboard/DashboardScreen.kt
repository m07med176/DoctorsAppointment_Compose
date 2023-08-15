package com.biteam.dataElTogar.presentation.features.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions


object DashboardScreen: Tab {

    override val options: TabOptions
        @Composable
        get(){
            val icon = rememberVectorPainter(Icons.Default.Add)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Home Screen",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "ViewMapScreen")
    }
}