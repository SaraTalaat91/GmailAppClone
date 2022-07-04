package com.example.gmailapp.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailapp.mailList
import com.example.gmailapp.models.MailItem

@Composable
fun MailList(paddingValues: PaddingValues, scrollState: ScrollState) {
    Box(modifier = Modifier.padding(paddingValues)) {
        LazyColumn(
            modifier = Modifier
                .scrollable(state = scrollState, orientation = Orientation.Vertical),
            contentPadding = PaddingValues(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 6.dp)
        ) {
            items(mailList) { mailItem ->
                MailListItem(mailItem = mailItem)
            }
        }
    }
}

@Composable
fun MailListItem(mailItem: MailItem, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(
            text = mailItem.userName[0].toString(),
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(
                    Color.Gray
                )
                .wrapContentHeight(),
            color = Color.White, textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        )
        {
            Text(text = mailItem.userName, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(
                text = mailItem.subject,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 2.dp)
            )
            Text(text = mailItem.body, fontSize = 14.sp, modifier = Modifier.padding(top = 2.dp))
        }

        Column(modifier = Modifier.padding(start = 4.dp)) {
            Text(text = mailItem.timeStamp, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(16.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.StarOutline,
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMailListItem() {
    MailList(paddingValues = PaddingValues(0.dp), scrollState = rememberScrollState())
}