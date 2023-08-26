package com.biteam.mohamed.presentation.features.profile

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.components.CustomAppBar
import com.biteam.mohamed.presentation.theme.SystemColor


object ProfileScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(id = R.drawable.profile_tap)

            return remember {
                TabOptions(
                    index = 3u,
                    title = "Profile",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ProfileContent(navigator)
    }
}


@Composable
fun SectionSettings(
    @DrawableRes imageId: Int,
    title: String,
    hideGoIcon: Boolean = false,
    onClicked: () -> Unit
) {

    Row(
        modifier = Modifier.padding(bottom = 30.dp, end = 40.dp, start = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .background(SystemColor.backgroundGray, shape = CircleShape)
                .padding(5.dp),
            painter = painterResource(id = imageId),
            contentDescription = title,
            contentScale = ContentScale.None
        )
        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(600),
                color = SystemColor.black,
                textAlign = TextAlign.Center,
            )
        )



        if (!hideGoIcon) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier
                    .clickable {
                        onClicked()
                    }
                    .size(25.dp)
                    .background(SystemColor.backgroundGray, shape = CircleShape)
                    .padding(5.dp),
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = title,
                contentScale = ContentScale.None
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileContent(navigator: Navigator? = null) {

    Scaffold(
        topBar = {
            CustomAppBar(title = "Profile") {
                navigator?.pop()
            }
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Card(shape = CircleShape, modifier = Modifier.size(130.dp)) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(29.dp))

            Text(
                text = "Mohamed Arfa",
                style = TextStyle(
                    fontSize = 22.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(700),
                    color = SystemColor.black,
                    textAlign = TextAlign.Center,
                )
            )

            Spacer(modifier = Modifier.height(37.dp))

           Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()
               .verticalScroll(rememberScrollState())){
                SectionSettings(imageId = R.drawable.history, title = "History") {}
                SectionSettings(imageId = R.drawable.personal_details, title = "Personal Detailes") {}
                SectionSettings(imageId = R.drawable.location, title = "Location") {}
                SectionSettings(imageId = R.drawable.payment, title = "Payment Method") {}
                SectionSettings(imageId = R.drawable.settings, title = "Settings") {}
                SectionSettings(imageId = R.drawable.help, title = "Help") {}
                SectionSettings(imageId = R.drawable.logout, hideGoIcon = true, title = "Logout") {}
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "Arabic",
    locale = "ar",
    device = Devices.PIXEL_3A_XL,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "English",
    locale = "en",
    device = Devices.PIXEL_3A_XL,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DoctorDetailsPreview() {
    ProfileContent()
}
