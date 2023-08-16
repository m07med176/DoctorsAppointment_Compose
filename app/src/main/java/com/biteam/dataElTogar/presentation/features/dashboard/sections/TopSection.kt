package com.biteam.dataElTogar.presentation.features.dashboard.sections

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biteam.dataElTogar.R
import com.biteam.dataElTogar.presentation.features.dashboard.DashboardContent

@Composable
fun TopSection() {
    Spacer(modifier = Modifier.height(30.dp))
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            modifier = Modifier.size(70.dp),
            contentDescription = "profile",
            contentScale = ContentScale.FillBounds
        )

        Column(Modifier.padding(start = 10.dp)) {
            Text(
                text = "Hi,Welcome Back,",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF858585),
                    letterSpacing = 0.4.sp,
                )
            )


            Text(
                text = "John Doe William",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    letterSpacing = 0.1.sp,
                )
            )


        }

        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(id = R.drawable.alarm_ic) , contentDescription = "alarm_ic",
        Modifier.padding(2.dp).size(32.dp))

    }
}


@Preview(
    showBackground = true,
    name = "English",
    locale = "en",
)
@Composable
fun TopSectionPreview() {
    TopSection()
}