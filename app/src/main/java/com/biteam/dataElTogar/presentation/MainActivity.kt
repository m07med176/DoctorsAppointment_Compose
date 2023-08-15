package com.biteam.dataElTogar.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.Navigator
import com.biteam.dataElTogar.presentation.features.authentication.LoginScreen
import com.biteam.dataElTogar.presentation.features.authentication.SplashScreen
import com.biteam.dataElTogar.presentation.theme.DataElTogarTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataElTogarTheme {
                Navigator(screen = SplashScreen)
                LaunchedEffect(key1 = true) {
                    delay(1000)
                    setContent {
                        Navigator(screen = LoginScreen)
                    }
                }
            }
        }
    }
}


