package com.example.gmailapp.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(val title: String, val icon: ImageVector) {
    object Mail : BottomNavigationItem(title = "Mail", icon = Icons.Outlined.Mail)
    object Meet : BottomNavigationItem(title = "Meet", icon = Icons.Outlined.VideoCall)
    object Chat : BottomNavigationItem(title = "Chat", icon = Icons.Outlined.Chat)
}