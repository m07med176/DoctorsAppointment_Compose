package com.biteam.dataElTogar.presentation.features.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.biteam.dataElTogar.presentation.features.HomeScreen
import com.biteam.dataElTogar.presentation.features.areasManagement.AreasScreen
import org.checkerframework.checker.units.qual.Area

object LoginScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column {
            Text(text = "Login Screen")
            Button(onClick = {
                    navigator.push(HomeScreen)
            },
                content = { Text(text = "Login") })
        }
    }
}