package com.biteam.mohamed.presentation.features.authentication


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.theme.headlineLarge

object SplashScreen : Screen {

    @Composable
    override fun Content() {
        SplashContent()

    }

}


@Composable
fun SplashContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(135.dp),
            painter = painterResource(id = R.drawable.medinova),
            contentDescription = "splash logo",
        )
        Text(
            text = "Medica",
            style = headlineLarge
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "Arabic",
    locale = "ar",
    device = "id:Galaxy Nexus",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "English",
    locale = "en",
    device = "id:Galaxy Nexus",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SplashPreview() {
    SplashContent()
}