package com.biteam.dataElTogar.presentation.features.viewMap

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions


object ViewMapScreen:Tab{

    override val options: TabOptions
        @Composable
        get(){
            val icon = rememberVectorPainter(Icons.Default.Check)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Map Togar",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val tabTitle = options.title

        LifecycleEffect(
            onStarted = { Log.d("Navigator", "Start tab $tabTitle") },
            onDisposed = { Log.d("Navigator", "Dispose tab $tabTitle") },
        )
    }
}