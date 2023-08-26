package com.biteam.mohamed.presentation.features.dashboard.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biteam.mohamed.presentation.components.SeeAllWithTitle
import com.biteam.mohamed.presentation.theme.SystemColor

@Composable
fun CategorySection() {
    Column {
        SeeAllWithTitle("Categories"){

        }


        val listData = listOf(
            "Denteeth","Theripist","Surgeon","Halak","Sarsagy"
        )
        
        LazyRow{
            items(listData){
                Box(
                    modifier = Modifier
                        .width(149.dp)
                        .height(82.dp)
                        .background(
                            color = SystemColor.secondary,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(start = 29.dp, top = 30.dp, end = 29.dp, bottom = 30.dp)
                ){
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(600),
                            color = Color.White,
                        )
                    )
                }

                Spacer(modifier = Modifier.width(15.dp))
            }
        }
    }
}