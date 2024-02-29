package com.app.moneyin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.moneyin.pojo.Spending
import com.app.moneyin.ui.theme.SecondaryGreen
import com.app.moneyin.utils.Utils

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MoneyInputBox(
    keyboardVisible: Boolean,
    onSave: (Spending) -> Unit
) {
    var money by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }


    Box(modifier = Modifier.background(Color.White)){
        Column {
            Box(modifier = Modifier.padding(all=10.dp)){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextField(
                        value = money,
                        onValueChange = { newmoney ->
                            money = newmoney
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = SecondaryGreen,
                            cursorColor = SecondaryGreen,
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            containerColor = Color.LightGray
                        ),
                        textStyle = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .size(width = 160.dp, height = 60.dp)
                            .focusRequester(focusRequester = focusRequester),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Text(
                        text = "Spent",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )

                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(all=10.dp)
            ) {
                Text(
                    text = "on",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(end = 16.dp)
                )
                TextField(
                    value = reason,
                    onValueChange = { newreason ->
                        reason = newreason
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        cursorColor = SecondaryGreen,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        containerColor = Color.LightGray
                    ),
                    textStyle = TextStyle(fontSize = 24.sp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Button(
                onClick = {
                    val spending = Spending(money=money.toDoubleOrNull() ?: 0.0, reason=reason,category="",
                        date=Utils.getCurrentDateTimeInMillis())
                    onSave(spending)
                },
                colors= ButtonDefaults.buttonColors(
                    containerColor = SecondaryGreen
                ),
                modifier = Modifier
                    .size(width = 120.dp, height = 60.dp)
                    .padding(all=10.dp)
            ) {
                Text(text="Save", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}

@Preview(name = "MoneyInputBox")
@Composable
private fun PreviewMoneyInputBox() {
}