package com.biteam.mohamed.presentation.features.appointment.sections

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.composable.TextHead3
import com.biteam.mohamed.presentation.composable.TextHead4
import com.biteam.mohamed.presentation.features.dashboard.listContent.DoctorModel
import com.biteam.mohamed.presentation.theme.SystemColor
import com.biteam.mohamed.presentation.utils.SimpleClick
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url

@Composable
fun DoctorContactSection(
    onClickChat: SimpleClick,
    onClickVideoCall: SimpleClick,
    onClickVoiceCall: SimpleClick,
    model: DoctorModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Card(modifier =
        Modifier
            .border(
                width = 1.dp,
                color = SystemColor.primary,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .size(132.dp),
        shape = RoundedCornerShape(size = 10.dp)) {
            KamelImage(
                resource = asyncPainterResource(data = Url(model.thumbnail)),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
                modifier =
                Modifier.fillMaxSize()
            )
        }


        Spacer(modifier = Modifier.width(21.dp))
        Column(Modifier.fillMaxHeight()) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextHead3(model.name)
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
                    color = SystemColor.primary,
                )
            )

            Spacer(modifier = Modifier.weight(0.5f))
            Row {
                TextHead4(
                    text = "Payment",
                )

                Spacer(modifier = Modifier.weight(1f))
                TextHead3(text = "$120.00", color = SystemColor.secondary)
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
    DoctorContactSection(onClickChat = {}, onClickVideoCall = {}, onClickVoiceCall = {}, model = DoctorModel(name = "Moahmed", thumbnail = ""))
}


// region Components
@Composable
fun ButtonImageHolderDoctorProfile(@DrawableRes drawableID: Int, simpleClick: SimpleClick) {
    Box(
        modifier = Modifier
            .background(color = SystemColor.backgroundGray, shape = CircleShape)
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