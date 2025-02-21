package com.keneth.hymnbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    onItemClick: (String) -> Unit,
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
            // Menu Header with Green Background
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)

            ) {
                Spacer(Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = "Menu",
                        modifier = Modifier
                            .padding(bottom = 16.dp, start = 16.dp)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White // Set text color to white for better visibility
                    )
                }
                HorizontalDivider(color = Color.White.copy(alpha = 0.5f)) // Add a divider for separation
            }
        }
        items(drawerScreens) { screen ->
            NavigationDrawerItem(
                modifier = Modifier.padding(10.dp),
                label = { Text(screen.title!!, style = MaterialTheme.typography.titleLarge) },
                selected = false,
                onClick = {
                    scope.launch { drawerState.close() }
                    onItemClick(screen.route)
                }
            )
        }
    }
}
