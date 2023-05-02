package com.wakeupgetapp.apifetchsampleapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wakeupgetapp.apifetchsampleapp.navigation.navGraph.homeNavGraph

@Composable
fun AfsaNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavRoutes.HOME_SCREEN
) {
    NavHost(navController = navController, startDestination = startDestination, route = NavRoutes.ROOT){
        homeNavGraph(navController = navController)
    }
}