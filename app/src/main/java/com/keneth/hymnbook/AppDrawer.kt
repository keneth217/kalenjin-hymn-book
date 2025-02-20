package com.keneth.hymnbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    onItemClick: (String) -> Unit, // Add click handler

) {
    val drawerScreens = listOf(
        Screens.HymnScreen,
        Screens.AboutScreen,
        Screens.SettingsScreen,
        Screens.FavoritesScreen
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Green)
            ) {
                Spacer(Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.Green)
                        .fillMaxSize()
                        .height(56.dp)
                ) {
                    Text(
                        "Menu",
                        Modifier.padding(16.dp),
                        style = MaterialTheme.typography.displayLarge
                    )
                }
                HorizontalDivider()
            }
        }
        items(drawerScreens) { screen ->
            NavigationDrawerItem(
                modifier = Modifier.padding(10.dp),
                label = { Text(screen.title!!, style = MaterialTheme.typography.bodyLarge) },
                selected = false,
                onClick = {
                    scope.launch { drawerState.close() }
                    onItemClick(screen.route)
                }
            )
        }
    }
}
