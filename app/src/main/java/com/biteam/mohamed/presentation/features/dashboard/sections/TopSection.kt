package com.biteam.mohamed.presentation.features.dashboard.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.composable.TextBody2
import com.biteam.mohamed.presentation.composable.TextHead3

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
            TextBody2(text = "Hi,Welcome Back,")
            TextHead3(text = "Mohamed Arfa")
        }

        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.alarm_ic), contentDescription = "alarm_ic",
            Modifier
                .padding(2.dp)
                .size(32.dp)
        )

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