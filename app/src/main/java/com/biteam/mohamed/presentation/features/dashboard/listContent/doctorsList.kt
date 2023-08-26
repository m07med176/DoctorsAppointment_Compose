package com.biteam.mohamed.presentation.features.dashboard.listContent

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biteam.mohamed.R
import com.biteam.mohamed.presentation.composable.SmallButton
import com.biteam.mohamed.presentation.composable.TextBody2
import com.biteam.mohamed.presentation.composable.TextHead3
import com.biteam.mohamed.presentation.theme.SystemColor
import com.biteam.mohamed.presentation.utils.ClickBookItem
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url


@SuppressLint("InvalidColorHexValue")
@Composable
fun DoctorItemCard(item: DoctorModel,onClickBook:()->Unit) {
    var changeFavorite by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .wrapContentHeight()
        .padding(bottom = 25.dp), shape = RoundedCornerShape(size = 10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color(0xA3E5FAF7)
                )
                .padding(end = 16.dp)
        ) {

            KamelImage(
                resource = asyncPainterResource(data = Url(item.thumbnail)),
                contentDescription = "image description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(120.dp)
                    .padding(end = 25.dp)
            )

            Column(
                modifier = Modifier
                    .wrapContentHeight()
            ) {
                Spacer(modifier = Modifier.height(12.dp))

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

                Spacer(modifier = Modifier.height(5.dp))
                TextBody2(text = item.description)

                Spacer(modifier = Modifier.height(5.dp))
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
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

    }

}

data class DoctorModel(
    val name: String = "Mohamed",
    val description: String = "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac mattis.",
    val rate: Float = 5f,
    val thumbnail:String,
    val saved: Boolean = false
)

@Preview(
    name = "English", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true
)
@Composable
fun DoctorItemCardPreview() {
    Box(modifier = Modifier.height(250.dp)) {
        DoctorItemCard(
            DoctorModel(
                thumbnail = "https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg",
                name = "Dr.Upul",
                description = "Worem consectetur adipiscing elit.",
                )
        ){}
    }

}

@Composable
fun LazyDoctorItems(modifier: Modifier = Modifier,onClickBookItem:ClickBookItem) {
    val itemsData =
        listOf(

            DoctorModel(
                thumbnail = "https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg",
                name = "Dr.Upul",
                description = "Worem consectetur adipiscing elit.",

            ),
            DoctorModel(
                thumbnail = "https://img.freepik.com/free-photo/young-man-doctor-wearing-white-coat-stethoscope-looking-sick-having-strong-pain-stomach-standing_141793-12608.jpg",
                name = "Dr.Silva",
                description = "Worem consectetur adipiscing elit.",
            ),
            DoctorModel(
                thumbnail = "https://img.freepik.com/premium-photo/young-asian-man-doctor-against-gray-wall_251136-40390.jpg",
                name = "Dr.Malcom",
                description = "Worem consectetur adipiscing elit.",

            ),
            DoctorModel(
                thumbnail = "https://img.freepik.com/premium-photo/handsome-bearded-man-doctor-with-eyeglasses-against-gray-wall_251136-68934.jpg",
                name = "Dr.Mohamed",
                description = "Worem consectetur adipiscing elit.",

            ),
            DoctorModel(
                thumbnail = "https://img.freepik.com/free-photo/portrait-cheerful-male-doctor-dressed-uniform_171337-1531.jpg",
                name = "Dr.Gamal",
                description = "Worem consectetur adipiscing elit.",

            ),
            DoctorModel(
                thumbnail = "https://img.freepik.com/free-photo/male-doctor-standing-with-hands-pockets-white-coat-looking-confident-front-view_176474-13329.jpg",
                name = "Dr.Sami",
                description = "Worem consectetur adipiscing elit.",
            ),
            DoctorModel(
                thumbnail = "https://img.freepik.com/free-photo/portrait-hansome-young-male-doctor-man_171337-5068.jpg",
                name = "Dr.Pawani",
                description = "Worem consectetur adipiscing elit.",

            ),
            DoctorModel(
                thumbnail = "https://img.freepik.com/premium-photo/young-handsome-indian-man-doctor_251136-50316.jpg",
                name = "Dr.Rayan",
                description = "Worem consectetur adipiscing elit.",
            ),
        )
       
    
    LazyColumn(modifier = modifier){
        items(itemsData){
            DoctorItemCard(it){
                onClickBookItem(it)
            }
        }
    }
}