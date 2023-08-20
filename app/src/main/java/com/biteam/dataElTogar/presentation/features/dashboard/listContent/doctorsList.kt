package com.biteam.dataElTogar.presentation.features.dashboard.listContent

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biteam.dataElTogar.R
import com.biteam.dataElTogar.presentation.composable.SmallButton
import com.biteam.dataElTogar.presentation.composable.TextBody2
import com.biteam.dataElTogar.presentation.composable.TextHead3
import com.biteam.dataElTogar.presentation.theme.SystemColor
import com.biteam.dataElTogar.presentation.utils.ClickBookItem


@Composable
fun DoctorItemCard(item: DoctorModel,onClickBook:()->Unit) {
    var changeFavorite by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .height(255.dp)
        .padding(bottom = 25.dp), shape = RoundedCornerShape(size = 10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color(0x4DD2EBE7)
                )
                .padding(start = 16.dp, end = 16.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(138.dp)
                    .padding(start = 14.dp, end = 25.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.doctor_image),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Spacer(modifier = Modifier.height(26.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextHead3(text = item.name)
                    Spacer(modifier = Modifier.weight(1f))
                    IconToggleButton(checked = changeFavorite,
                        onCheckedChange = { changeFavorite = !changeFavorite }) {
                        Icon(
                            imageVector = if (changeFavorite) Icons.Outlined.Favorite else Icons.Default.Favorite,
                            contentDescription = null
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))
                TextBody2(text = item.description)

                Spacer(modifier = Modifier.height(20.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    SmallButton(
                        title = "Book", modifier = Modifier
                            .height(40.dp)
                    ) {
                        onClickBook()
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.star_icon),
                        modifier = Modifier
                            .size(20.dp)
                            .padding(end = 6.dp),
                        contentDescription = null,
                        tint = SystemColor.orange
                    )
                    TextHead3(text = item.rate.toString())
                }
            }
        }

    }

}

data class DoctorModel(
    val name: String = "Mohamed",
    val description: String = "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac mattis.",
    val rate: Float = 5f,
    val saved: Boolean = false
)

@Preview(
    name = "English", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true
)
@Composable
fun DoctorItemCardPreview() {
    Box(modifier = Modifier.height(250.dp)) {
        DoctorItemCard(DoctorModel()){}
    }

}

@Composable
fun LazyDoctorItems(modifier: Modifier = Modifier,onClickBookItem:ClickBookItem) {
    var itemsData: MutableList<DoctorModel> = mutableListOf<DoctorModel>().apply {
        repeat(10) {
            add(
                DoctorModel(
                    name = "Dr.DoctorName$it"
                )
            )
        }
    }
    LazyColumn(modifier = modifier){
        items(itemsData){
            DoctorItemCard(it){
                onClickBookItem(it)
            }
        }
    }
}