package com.biteam.dataElTogar.presentation.features.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.biteam.dataElTogar.presentation.features.HomeScreen
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

object LoginScreen : Screen {

    @Composable
    override fun Content() {
        val productsViewModel = getViewModel(Unit, viewModelFactory { AuthenticationViewModel() })
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
