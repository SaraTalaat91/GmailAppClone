package com.example.gmailapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmailapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GmailAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope, openDialog: MutableState<Boolean>) {
    Box(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White),
            shape = RoundedCornerShape(6.dp),
            elevation = 6.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }, modifier = Modifier
                        .size(25.dp)
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }

                Text(
                    text = "Search in mail", modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.tutorials),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            Color.LightGray
                        )
                        .size(30.dp).clickable { openDialog.value = true }
                )

                if(openDialog.value){
                    AccountsDialog(openDialog = openDialog)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GmailAppBarPreview() {
    GmailAppBar(rememberScaffoldState(), rememberCoroutineScope(), remember { mutableStateOf(false)})
}