package com.example.gmailapp.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.gmailapp.models.BottomNavigationItem

@Composable
fun GmailBottomNavigation() {
    val items = listOf(
        BottomNavigationItem.Mail,
        BottomNavigationItem.Chat,
        BottomNavigationItem.Meet
    )
    BottomNavigation(backgroundColor = Color.White, contentColor = Color.Black) {
        items.forEach { item ->
            BottomNavigationItem(
                selected = false,
                onClick = { },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                alwaysShowLabel = true
            )
        }
    }
}