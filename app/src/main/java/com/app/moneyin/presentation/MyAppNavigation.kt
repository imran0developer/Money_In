package com.app.moneyin.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.moneyin.presentation.screens.Home
import com.app.moneyin.utils.Constants.HOME_ROUTE

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME_ROUTE, builder = {
        composable(route=HOME_ROUTE){
            Home(navController)
        }
    } )
}
