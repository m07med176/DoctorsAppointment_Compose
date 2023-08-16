package com.biteam.dataElTogar.presentation.features.chat

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.biteam.dataElTogar.R


object ChatScreen:Tab{

    override val options: TabOptions
        @Composable
        get(){
            val icon = painterResource(id = R.drawable.chat_tap)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Chat",
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