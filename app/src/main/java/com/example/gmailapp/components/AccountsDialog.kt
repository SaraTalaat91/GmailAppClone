package com.example.gmailapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material.icons.outlined.PersonSearch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.gmailapp.R
import com.example.gmailapp.accountList
import com.example.gmailapp.models.Account

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false }) {
        Card {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { openDialog.value = false }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "close",
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google",
                        modifier = Modifier
                            .weight(1f)
                            .height(30.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                GmailAccountItem(accountItem = accountList[0])

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Card(
                        shape = RoundedCornerShape(50.dp),
                        border = BorderStroke(1.dp, Color.Gray),
                        modifier = Modifier.padding(start = 50.dp)
                    ) {
                        Text(
                            text = "Google Account",
                            fontSize = 13.sp,
                            modifier = Modifier.padding(8.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Divider(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp)
                )

                GmailAccountItem(accountItem = accountList[1])
                GmailAccountItem(accountItem = accountList[2])

                Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp), verticalAlignment = Alignment.CenterVertically){
                    Icon(imageVector = Icons.Outlined.PersonAdd, contentDescription = "add account"
                    , modifier = Modifier.size(40.dp).padding(10.dp))
                    Text(text = "Add another account", fontWeight = FontWeight.SemiBold)
                }

                Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 16.dp), verticalAlignment = Alignment.CenterVertically){
                    Icon(imageVector = Icons.Outlined.PersonSearch, contentDescription = "add account"
                        , modifier = Modifier.size(40.dp).padding(10.dp))
                    Text(text = "Manage accounts on this device", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Composable
fun GmailAccountItem(accountItem: Account, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        if (accountItem.icon != null) {
            Image(
                painter = painterResource(id = accountItem.icon),
                contentDescription = "account image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
        } else {
            Text(
                text = accountItem.userName[0].toString(),
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        Color.Gray
                    )
                    .wrapContentHeight(),
                color = Color.White, textAlign = TextAlign.Center
            )

        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        ) {
            Text(text = accountItem.userName, fontWeight = FontWeight.SemiBold)
            Text(text = accountItem.email, color = Color.DarkGray, fontSize = 13.sp)
        }

        Text(
            text = accountItem.unReadMails.toString(),
            color = Color.DarkGray,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAccountsDialog() {
    AccountsDialog(openDialog = remember { mutableStateOf(true) })
}
