package com.biteam.mohamed.presentation.features.appointment.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biteam.mohamed.presentation.theme.SystemColor

@Composable
fun DetailsDoctorSection() {
    Column {
        Text(
            text = "Details",
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(600),
                color = SystemColor.black,
            )
        )

        Spacer(modifier = Modifier.height(17.dp))
        Text(
            text = "Worem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vulputate libero et velit interdum, ac aliquet odio mattis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur tempus urna at turpis condimentum lobortis. Ut commodo efficitur neque. Ut diam quam, semper iaculis condimentum ac, vestibulum eu nisl.",
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 17.16.sp,
                fontWeight = FontWeight(400),
                color = SystemColor.textGray,
            )
        )
    }
}