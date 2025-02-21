package com.keneth.hymnbook


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun BottomNavBar(navController: NavController, currentRoute: String) {
    val items = listOf(
        BottomNavItem(Screens.HymnScreen.route, Icons.Default.Home, "Home"),
        BottomNavItem(Screens.AboutScreen.route, Icons.Default.Info, "About"),
        BottomNavItem(Screens.FavoritesScreen.route, Icons.Default.Favorite, "Favorites"),
        BottomNavItem(Screens.SettingsScreen.route, Icons.Default.Settings, "Settings"),
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    // Only navigate if the item is not already selected
                    if (!isSelected) {
                        navController.navigate(item.route) {
                            // Avoid multiple copies of the same destination in the back stack
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(
                            alpha = 0.6f
                        )
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(
                            alpha = 0.6f
                        )
                    )
                },
                selectedContentColor = MaterialTheme.colorScheme.onPrimary, // Selected color
                unselectedContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f)
            )
            // Unselected color
        }
    }
}

data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)