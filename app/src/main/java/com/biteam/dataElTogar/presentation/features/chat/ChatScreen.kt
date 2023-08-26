package com.biteam.dataElTogar.presentation.features.chat

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.biteam.dataElTogar.R
import com.biteam.dataElTogar.presentation.components.CustomAppBar
import com.biteam.dataElTogar.presentation.features.dashboard.sections.SearchSection
import com.biteam.dataElTogar.presentation.theme.SystemColor
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url
import kotlin.random.Random


object ChatScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(id = R.drawable.chat_tap)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Chat",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val tabTitle = options.title

        val navigator = LocalNavigator.currentOrThrow

        val actions = ChatCallBackActions(
            onMessageItemClicked = {
                navigator.parent?.push(ChatRoomScreen(name = it.name,id=it.id))
            },
            onActiveItemClicked = {
                navigator.parent?.push(ChatRoomScreen(name = it.name,id=it.id))
            }
        )
        LifecycleEffect(
            onStarted = { Log.d("Navigator", "Start tab $tabTitle") },
            onDisposed = { Log.d("Navigator", "Dispose tab $tabTitle") },
        )

        ChatContent(actions = actions)
    }
}

data class ChatCallBackActions(
    val onMessageItemClicked: (MessageModel) -> Unit,
    val onActiveItemClicked: (ActiveModel) -> Unit
)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChatContent(actions:ChatCallBackActions) {

    Scaffold(
        topBar = {
            CustomAppBar(title = "Message") {

            }
        },
        modifier = Modifier
            .padding(26.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(25.dp))

            SearchSection(title = "Search A Doctor") {

            }

            Spacer(modifier = Modifier.height(25.dp))

            ActiveNowSection{
                actions.onActiveItemClicked(it)
            }

            Spacer(modifier = Modifier.height(25.dp))

            MessagesSection{
                actions.onMessageItemClicked(it)
            }
        }
    }
}

// region Message
data class MessageModel(
    val thumbnail: String,
    val name: String,
    val lastMessage: String,
    val lastTime: String,
    val unreadMessages: Int? = null,
    val id: Int = Random.nextInt(100),
    val isOnline: Boolean = false
)

@Composable
fun MessagesSection(onItemClicked:(MessageModel)->Unit) {
    Column {
        Text(
            text = "Messages",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(600),
                color = SystemColor.black,
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        val activeList = listOf(
            MessageModel(
                thumbnail = "https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg",
                isOnline = true,
                name = "Dr.Upul",
                lastMessage = "Worem consectetur adipiscing elit.",
                unreadMessages = 2,
                lastTime = "12.50"

            ),
            MessageModel(
                thumbnail = "https://img.freepik.com/free-photo/young-man-doctor-wearing-white-coat-stethoscope-looking-sick-having-strong-pain-stomach-standing_141793-12608.jpg",
                isOnline = false,
                name = "Dr.Silva",
                lastMessage = "Worem consectetur adipiscing elit.",
                lastTime = "12.50"
            ),
            MessageModel(
                thumbnail = "https://img.freepik.com/premium-photo/young-asian-man-doctor-against-gray-wall_251136-40390.jpg",
                isOnline = true,
                name = "Dr.Malcom",
                lastMessage = "Worem consectetur adipiscing elit.",
                lastTime = "12.50"

            ),
            MessageModel(
                thumbnail = "https://img.freepik.com/premium-photo/handsome-bearded-man-doctor-with-eyeglasses-against-gray-wall_251136-68934.jpg",
                isOnline = true,
                name = "Dr.Mohamed",
                lastMessage = "Worem consectetur adipiscing elit.",
                unreadMessages = 2,
                lastTime = "12.50"

            ),
            MessageModel(
                thumbnail = "https://img.freepik.com/free-photo/portrait-cheerful-male-doctor-dressed-uniform_171337-1531.jpg",
                isOnline = false,
                name = "Dr.Gamal",
                lastMessage = "Worem consectetur adipiscing elit.",
                unreadMessages = 5,
                lastTime = "12.50"

            ),
            MessageModel(
                thumbnail = "https://img.freepik.com/free-photo/male-doctor-standing-with-hands-pockets-white-coat-looking-confident-front-view_176474-13329.jpg",
                isOnline = true,
                name = "Dr.Sami",
                lastMessage = "Worem consectetur adipiscing elit.",
                lastTime = "12.50"

            ),
            MessageModel(
                thumbnail = "https://img.freepik.com/free-photo/portrait-hansome-young-male-doctor-man_171337-5068.jpg",
                isOnline = true,
                name = "Dr.Pawani",
                lastMessage = "Worem consectetur adipiscing elit.",
                lastTime = "12.50"

            ),
            MessageModel(
                thumbnail = "https://img.freepik.com/premium-photo/young-handsome-indian-man-doctor_251136-50316.jpg",
                isOnline = false,
                name = "Dr.Rayan",
                lastMessage = "Worem consectetur adipiscing elit.",
                unreadMessages = 1,
                lastTime = "12.50"

            ),
        )
        LazyColumn {
            items(activeList) {
                MessagesItem(it) {
                    onItemClicked(it)
                }
            }
        }

    }
}

@Preview
@Composable
fun MessageItemPreview() {
    MessagesItem(
        model = MessageModel(
            thumbnail = "https://img.freepik.com/premium-photo/young-handsome-indian-man-doctor_251136-50316.jpg",
            isOnline = false,
            name = "Dr.Rayan",
            lastMessage = "Worem consectetur adipiscing elit.",
            unreadMessages = 1,
            lastTime = "12.50"

        )
    ) {

    }
}

@Composable
fun MessagesItem(model: MessageModel, onItemClicked: (MessageModel) -> Unit) {
    Row(modifier = Modifier
        .padding(bottom = 15.dp)
        .clickable {
            onItemClicked(model)
        }) {
        Card(shape = CircleShape) {
            KamelImage(
                resource = asyncPainterResource(data = Url(model.thumbnail)),
                modifier = Modifier
                    .background(color = SystemColor.backgroundGray, shape = CircleShape)
                    .size(60.dp),
                contentDescription = "image description",
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(27.dp))

        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround) {
            Text(
                text = model.name,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(600),
                    color = SystemColor.black,
                )
            )

            Text(
                text = model.lastMessage,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    fontWeight = FontWeight(400),
                    color = SystemColor.textGray,
                )
            )
        }

        Spacer(modifier = Modifier.width(20.dp))

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = model.lastTime,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        fontWeight = FontWeight(400),
                        color = SystemColor.black,
                    )
                )

                model.unreadMessages?.let {
                    Box(
                        modifier = Modifier
                            .padding(1.dp)
                            .size(20.dp)
                            .background(color = SystemColor.primary, shape = CircleShape),
                        contentAlignment = Alignment.Center,

                        ) {
                        Text(
                            text = model.unreadMessages.toString(),
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 12.sp,
                                fontWeight = FontWeight(400),
                                color = Color.White,
                            )
                        )
                    }

                }

            }

    }
}
// endregion Message


// region Active Now Section
@Composable
fun ActiveNowSection(onItemClicked: (ActiveModel) -> Unit) {
    Column {
        Text(
            text = "Active Now",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(600),
                color = SystemColor.black,
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        val activeList = listOf(
            ActiveModel(
                thumbnail = "https://img.freepik.com/free-photo/smiling-doctor-with-strethoscope-isolated-grey_651396-974.jpg",
                isOnline = true
            ),
            ActiveModel(
                thumbnail = "https://img.freepik.com/free-photo/young-man-doctor-wearing-white-coat-stethoscope-looking-sick-having-strong-pain-stomach-standing_141793-12608.jpg",
                isOnline = false
            ),
            ActiveModel(
                thumbnail = "https://img.freepik.com/premium-photo/young-asian-man-doctor-against-gray-wall_251136-40390.jpg",
                isOnline = true
            ),
            ActiveModel(
                thumbnail = "https://img.freepik.com/premium-photo/handsome-bearded-man-doctor-with-eyeglasses-against-gray-wall_251136-68934.jpg",
                isOnline = true
            ),
            ActiveModel(
                thumbnail = "https://img.freepik.com/free-photo/portrait-cheerful-male-doctor-dressed-uniform_171337-1531.jpg",
                isOnline = false
            ),
            ActiveModel(
                thumbnail = "https://img.freepik.com/free-photo/male-doctor-standing-with-hands-pockets-white-coat-looking-confident-front-view_176474-13329.jpg",
                isOnline = true
            ),
            ActiveModel(
                thumbnail = "https://img.freepik.com/free-photo/portrait-hansome-young-male-doctor-man_171337-5068.jpg",
                isOnline = true
            ),
            ActiveModel(
                thumbnail = "https://img.freepik.com/premium-photo/young-handsome-indian-man-doctor_251136-50316.jpg",
                isOnline = false
            ),
        )
        LazyRow {
            items(activeList) {
                ActiveNowItem(it) {
                    onItemClicked(it)
                }
            }
        }

    }
}

data class ActiveModel(
    val thumbnail: String,
    val name: String = "Dr.Upul",
    val id: Int = Random.nextInt(100),
    val isOnline: Boolean = false
)

@Composable
fun ActiveNowItem(model: ActiveModel, onItemClicked: (ActiveModel) -> Unit) {
    Box(modifier = Modifier
        .padding(horizontal = 4.dp)
        .clickable {
            onItemClicked(model)
        }) {
        Card(shape = CircleShape) {
            KamelImage(
                resource = asyncPainterResource(data = Url(model.thumbnail)),
                modifier = Modifier
                    .background(color = SystemColor.backgroundGray, shape = CircleShape)
                    .size(60.dp),
                contentDescription = "image description",
                contentScale = ContentScale.Crop
            )
        }
        Column {
            Box(
                modifier = Modifier
                    .background(
                        if (model.isOnline) Color.Green else Color.Red,
                        shape = CircleShape
                    )
                    .size(15.dp)
            )
        }
    }
}
// endregion Active Now Section


@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "Arabic",
    locale = "ar",
    device = Devices.PIXEL_3A_XL,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "English",
    locale = "en",
    device = Devices.PIXEL_3A_XL,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ChatPreview() {
    ChatContent(ChatCallBackActions(
        onActiveItemClicked = {},
        onMessageItemClicked = {}
    ))
}