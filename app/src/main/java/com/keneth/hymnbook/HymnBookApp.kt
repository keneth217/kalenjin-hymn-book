package com.keneth.hymnbook

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun HymnBookApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route,
        modifier = modifier
    ) {
        composable(Screens.SplashScreen.route) { SplashScreen(navController) }
        composable(Screens.AboutScreen.route) { AboutScreen(navController) }


        composable(Screens.FavoritesScreen.route) { FavoriteScreen(navController) }
        composable(Screens.SettingsScreen.route) { SettingsScreen(navController) }
        composable(Screens.HymnScreen.route) {
            HymnScreen(
                navController = navController,
                modifier = Modifier,
            )
        }
        composable(
            route = "${Screens.HymnDetailScreen.route}/{hymnNumber}",
            arguments = listOf(navArgument("hymnNumber") { type = NavType.IntType })
        ) { backStackEntry ->
            val hymnNumber = backStackEntry.arguments?.getInt("hymnNumber") ?: 0
            HymnDetailScreen(
                hymnNumber = hymnNumber,
                navController = navController
            )
        }
    }
}





