package com.biteam.mohamed.presentation.composable

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.features.appointment.AppointmentScreen
import com.biteam.mohamed.presentation.features.chat.ChatScreen
import com.biteam.mohamed.presentation.features.dashboard.DashboardScreen
import com.biteam.mohamed.presentation.features.profile.ProfileScreen
import com.biteam.mohamed.presentation.theme.SystemColor

val NAVIGATION_HEIGHT = 90.dp

@Composable
fun ButtonNavigation() {
    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(NAVIGATION_HEIGHT)
    ) {
        TabNavigationItem(DashboardScreen)
        TabNavigationItem(AppointmentScreen)
        TabNavigationItem(ChatScreen)
        TabNavigationItem(ProfileScreen)
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    TabNavigationItemPreview(tab.options.icon!!,tab.options.title,tabNavigator.current.key == tab.key){
        tabNavigator.current = tab
    }
}


@Preview(
    name = "English",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ButtonNavigationPreview() {
    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(83.dp)
    ) {

        TabNavigationItemPreview(painterResource(id = R.drawable.home_tap),"Home",true){

        }
        TabNavigationItemPreview(painterResource(id = R.drawable.appointment_tap),"Booking"){

        }
        TabNavigationItemPreview(painterResource(id = R.drawable.chat_tap),"Chat"){

        }
        TabNavigationItemPreview(painterResource(id = R.drawable.profile_tap),"Profile"){

        }
    }
}

@Composable
private fun RowScope.TabNavigationItemPreview(image: Painter, title:String, selected:Boolean = false,onClick:()->Unit) {
    BottomNavigationItem(
        icon = {
            Icon(
                painter = image,
                contentDescription = title,
                tint = if (selected) Color.White else Color.Black,
                modifier = Modifier.size(24.dp)
            )
        },
        label = { Text(text = title) },
        selected = selected,
        onClick = { onClick() },
        alwaysShowLabel = true,
        selectedContentColor = Color.White,
        unselectedContentColor = Color.Black,
        modifier = Modifier
            .padding(13.dp)
            .background(
                color = if (selected) SystemColor.primary else Color.White ,
                shape = RoundedCornerShape(size = 10.dp)
            )

    )
}
