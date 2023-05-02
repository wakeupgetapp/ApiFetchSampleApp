package com.wakeupgetapp.apifetchsampleapp.navigation

sealed class AfsaRoutes(val route: String) {
    object HomeScreenRoute: AfsaRoutes("homeScreen")
}