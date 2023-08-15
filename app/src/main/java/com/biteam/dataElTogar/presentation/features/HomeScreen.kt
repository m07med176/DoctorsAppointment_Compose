package com.biteam.dataElTogar.presentation.features

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.biteam.dataElTogar.presentation.features.areasManagement.AreasScreen
import com.biteam.dataElTogar.presentation.features.dashboard.DashboardScreen
import com.biteam.dataElTogar.presentation.features.profile.ProfileScreen
import com.biteam.dataElTogar.presentation.features.appointment.AppointmentScreen
import com.biteam.dataElTogar.presentation.features.viewMap.ChatScreen

object HomeScreen :Screen{
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        TabNavigator(
            DashboardScreen
        ) { tabNavigator ->
            Scaffold(
//                topBar = {
//                    TopAppBar(
//                        title = { Text(text = tabNavigator.current.options.title) },
//                        actions = { AppDropMenu(navigator) }
//                    )
//                },
                content = {
                    CurrentTab()
                },
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(DashboardScreen)
                        TabNavigationItem(AppointmentScreen)
                        TabNavigationItem(ChatScreen)
                        TabNavigationItem(ProfileScreen)
                    }
                }
            )
        }



    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) }
    )
}

@Composable
private fun AppDropMenu(navigator: Navigator) {
    val context = LocalContext.current

    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More"
            )
        }


        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    navigator.push(AreasScreen)
                },
                content = { Text(text = "المناطق") }
            )
            DropdownMenuItem(
                onClick = { Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show() },
                content = { Text(text = "خروج") }
            )

        }


    }
}