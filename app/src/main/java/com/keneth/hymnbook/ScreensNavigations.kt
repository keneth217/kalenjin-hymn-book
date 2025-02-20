package com.keneth.hymnbook

sealed class Screens(val route: String, val title: String? = null, open val icon: Int? = null) {
    object SplashScreen : Screens("splash_screen",)
    object HymnScreen : Screens("hymns_screen", "Hymns")
    object HymnDetailScreen : Screens("hymn_detail", "Song Title",)
    object AboutScreen : Screens("about_screen", "About")
    object SettingsScreen : Screens("settings_screen", "Settings")
    object FavoritesScreen : Screens("favourites_screen", "Favourites")


}