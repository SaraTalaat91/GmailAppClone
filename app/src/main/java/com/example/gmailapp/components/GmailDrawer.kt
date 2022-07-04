package com.example.gmailapp.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailapp.models.DrawerItem


@Composable
fun GmailDrawer(scrollState: ScrollState) {
    val menuList = listOf(
        DrawerItem.Divider,
        DrawerItem.AllInboxes,
        DrawerItem.Divider,
        DrawerItem.Primary,
        DrawerItem.Social,
        DrawerItem.Promotions,
        DrawerItem.HeaderOne,
        DrawerItem.Starred,
        DrawerItem.Snoozed,
        DrawerItem.Important,
        DrawerItem.Sent,
        DrawerItem.Schedule,
        DrawerItem.Outbox,
        DrawerItem.Draft,
        DrawerItem.AllMail,
        DrawerItem.HeaderTwo,
        DrawerItem.Calendar,
        DrawerItem.Contacts,
        DrawerItem.Divider,
        DrawerItem.Setting,
        DrawerItem.Help
    )

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Gmail",
            fontSize = 18.sp,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
            fontWeight = FontWeight.Bold
        )

        menuList.forEach { item ->
            when (item) {
                is DrawerItem.Divider -> {
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp))
                }
                is DrawerItem.HeaderOne, DrawerItem.HeaderTwo -> {
                    Text(
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                        text = item.title ?: "",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                else -> {
                    MenuItem(drawerItem = item)
                }
            }
        }
    }
}

@Composable
fun MenuItem(drawerItem: DrawerItem) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = drawerItem.icon!!,
            contentDescription = "",
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = drawerItem.title ?: "",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.weight(1f)
        )
    }
}