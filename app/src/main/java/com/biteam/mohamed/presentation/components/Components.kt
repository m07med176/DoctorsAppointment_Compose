package com.biteam.mohamed.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.composable.TextHead1
import com.biteam.mohamed.presentation.theme.SystemColor
import com.biteam.mohamed.presentation.theme.bodyMedium
import com.biteam.mohamed.presentation.theme.headlineSmall
import com.biteam.mohamed.presentation.utils.SimpleClick

@Composable
fun SeeAllWithTitle(title:String,onClick:SimpleClick) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Text(text = title, style = headlineSmall)

        Spacer(modifier = Modifier.weight(1f))

        TextButton(onClick = onClick) {
            Text(
                text = "See All",
                style = bodyMedium,
                textAlign = TextAlign.Start
            )
        }
    }

}

@Composable
fun CustomToggleButtonList(
    title: String,
    currentToggleState: String,
    modifier: Modifier = Modifier,
    onClickButton: (String) -> Unit
) {
    Button(
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = SystemColor.backgroundGray,
            contentColor = Color.Black,
            disabledBackgroundColor = SystemColor.primary,
            disabledContentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(0.dp),
        enabled = title != currentToggleState,
        onClick = { onClickButton(title) }) {
        androidx.compose.material.Text(
            text = title,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
            )
        )
    }
}


@Composable
fun CustomAppBar(title: String,modifier: Modifier = Modifier,onClick: SimpleClick) {
    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        modifier = modifier.padding(top = 20.dp)
    ) {


        IconButton(onClick = onClick) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.back_ic),
                contentDescription = null
            )
        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            TextHead1(text = title )
        }

    }

}