package com.example.gmailapp.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GmailFab(scrollState: ScrollState) {
    if (scrollState.value > 100) {
        ExtendedFloatingActionButton(
            text = { Text(text = "Compose") },
            icon = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Compose")
            },
            onClick = { /*TODO*/ },
            backgroundColor = Color.White
        )
    } else {
        FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Color.White) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Compose")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGmailFab() {
    GmailFab(rememberScrollState())
}