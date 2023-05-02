package com.wakeupgetapp.apifetchsampleapp.navigation.navGraph

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.HomeRoute
import com.wakeupgetapp.apifetchsampleapp.navigation.AfsaRoutes
import com.wakeupgetapp.apifetchsampleapp.navigation.NavRoutes

fun NavGraphBuilder.homeNavGraph(navController: NavController) {

    navigation(startDestination = AfsaRoutes.HomeScreenRoute.route, route = NavRoutes.HOME_SCREEN) {
        composable(route = AfsaRoutes.HomeScreenRoute.route) {
            HomeRoute(navController = navController as NavHostController)
        }
    }
}