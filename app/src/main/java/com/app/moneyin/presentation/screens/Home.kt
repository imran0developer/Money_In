package com.app.moneyin.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.moneyin.MoneyInputBox
import com.app.moneyin.ui.theme.NeutralGrey
import com.app.moneyin.utils.Constants.TAG

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun Home(
    navController: NavController
) {
    val keyboardVisible =  WindowInsets.isImeVisible

    Box(

        modifier = Modifier
            .background(NeutralGrey)
            .fillMaxSize()
            .padding(top = 24.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            Box(modifier =
//            Modifier.offset(y= if (keyboardVisible) 300.dp else 10.dp)
            Modifier.offset(y= if (keyboardVisible) 10.dp else 10.dp)
            ) {
                MoneyInputBox(keyboardVisible = true, onSave = {
                    Log.d(TAG, "keyboardVisible: $keyboardVisible")
                })
            }
        }
    }
}

fun saveData(money: Double) {

}

@Preview(name = "Home")
@Composable
private fun PreviewHome() {
}