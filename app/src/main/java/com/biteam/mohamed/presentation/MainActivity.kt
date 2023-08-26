package com.biteam.mohamed.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.core.view.WindowCompat
import cafe.adriel.voyager.navigator.Navigator
import com.biteam.mohamed.presentation.features.authentication.LoginScreen
import com.biteam.mohamed.presentation.features.authentication.SplashScreen
import com.biteam.mohamed.presentation.theme.DataElTogarTheme
import com.google.accompanist.insets.ProvideWindowInsets
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            ProvideWindowInsets {
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
}


