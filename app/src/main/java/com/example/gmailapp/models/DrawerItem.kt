package com.example.gmailapp.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerItem(
    val title: String? = null,
    val icon: ImageVector? = null,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false
){
    object AllInboxes: DrawerItem(
        icon = Icons.Outlined.AllInbox,
        title = "All inboxes"
    )
    object Primary: DrawerItem(
        icon = Icons.Outlined.Inbox,
        title = "Primary"
    )
    object Social: DrawerItem(
        icon = Icons.Outlined.Person,
        title = "Social"
    )
    object Promotions: DrawerItem(
        icon = Icons.Outlined.Tag,
        title = "Promotions",
    )
    object Starred: DrawerItem(
        icon = Icons.Outlined.StarOutline,
        title = "Starred"
    )

    object Snoozed: DrawerItem(
        icon = Icons.Outlined.Snooze,
        title = "Snoozed"
    )
    object Important: DrawerItem(
        icon = Icons.Outlined.Label,
        title = "Important"
    )
    object Sent: DrawerItem(
        icon = Icons.Outlined.Send,
        title = "Sent"
    )
    object Schedule: DrawerItem(
        icon = Icons.Outlined.Schedule,
        title = "Scheduled"
    )
    object Outbox: DrawerItem(
        icon = Icons.Outlined.Outbox,
        title = "Outbox"
    )
    object Draft: DrawerItem(
        icon = Icons.Outlined.Drafts,
        title = "Drafts"
    )
    object AllMail: DrawerItem(
        icon = Icons.Outlined.Mail,
        title = "All Mail"
    )
    object Calendar: DrawerItem(
        icon = Icons.Outlined.CalendarToday,
        title = "Calendar"
    )
    object Contacts: DrawerItem(
        icon = Icons.Outlined.Contacts,
        title = "Contacts"
    )
    object Setting: DrawerItem(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    )
    object Help: DrawerItem(
        icon = Icons.Outlined.Help,
        title = "Help & FeedBack"
    )

    object Divider: DrawerItem(
        isDivider = true
    )

    object HeaderOne: DrawerItem(
        isHeader = true,
        title = "ALL LABELS"
    )
    object HeaderTwo: DrawerItem(
        isHeader = true,
        title = "GOOGLE APPS"
    )
}
