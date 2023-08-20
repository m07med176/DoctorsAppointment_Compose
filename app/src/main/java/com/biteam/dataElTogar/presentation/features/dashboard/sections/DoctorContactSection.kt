package com.biteam.dataElTogar.presentation.features.dashboard.sections

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biteam.dataElTogar.R
import com.biteam.dataElTogar.presentation.composable.TextHead3
import com.biteam.dataElTogar.presentation.composable.TextHead4
import com.biteam.dataElTogar.presentation.theme.primary
import com.biteam.dataElTogar.presentation.theme.secondary
import com.biteam.dataElTogar.presentation.utils.SimpleClick

@Composable
fun DoctorContactSection(
    onClickChat: SimpleClick,
    onClickVideoCall: SimpleClick,
    onClickVoiceCall: SimpleClick
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.doctor_profile_imags),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier =
            Modifier
                .border(
                    width = 1.dp,
                    color = primary,
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .size(132.dp)
        )

        Spacer(modifier = Modifier.width(21.dp))
        Column(Modifier.fillMaxHeight()) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextHead3("Dr.Upul")
                ButtonImageHolderDoctorProfile(R.drawable.chat_ic, simpleClick = onClickChat)
                ButtonImageHolderDoctorProfile(
                    R.drawable.voice_call_ic,
                    simpleClick = onClickVoiceCall
                )
                ButtonImageHolderDoctorProfile(
                    R.drawable.video_call_ic,
                    simpleClick = onClickVideoCall
                )
            }

            Text(
                text = "denteeth",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF7BC1B7),
                )
            )

            Spacer(modifier = Modifier.weight(1f))
            Row {
                TextHead4(
                    text = "Payment",
                )

                Spacer(modifier = Modifier.height(32.dp))
                TextHead3(text = "$120.00", color = secondary)
            }
        }
    }
}


@Preview(
    showBackground = true,
    name = "English",
    locale = "en",
)
@Composable
fun DoctorContactPreview() {
    DoctorContactSection(onClickChat = {}, onClickVideoCall = {}, onClickVoiceCall = {})
}


// region Components
@Composable
fun ButtonImageHolderDoctorProfile(@DrawableRes drawableID: Int, simpleClick: SimpleClick) {
    Box(
        modifier = Modifier
            .background(color = secondary, shape = CircleShape)
            .size(30.dp),
        contentAlignment = Alignment.Center

    ) {
        IconButton(onClick = simpleClick) {
            Image(
                painter = painterResource(id = drawableID),
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize()
            )
        }

    }


}
// endregion Components