package com.keneth.hymnbook

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun FavoriteScreen(navController: NavHostController) {

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val currentRoute =
        navController.currentBackStackEntry?.destination?.route ?: Screens.HymnScreen.route
    val searchQuery = remember { mutableStateOf("") }
    val allFavHymns = remember { HymnRepository.getFavHymns() }

    val filteredHymns = remember(searchQuery.value) {
        if (searchQuery.value.isEmpty()) {
            allFavHymns
        } else {
            allFavHymns.filter { hymn ->
                hymn.number.toString().contains(searchQuery.value, ignoreCase = true) ||
                        hymn.title.contains(searchQuery.value, ignoreCase = true)
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                AppDrawer(
                    drawerState, scope,
                    onItemClick = { route -> navController.navigate(route) }, currentRoute
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopBar(scope, drawerState, "My  Favorite Kalenjin Hymns", onBottomSheetOpen = {})
            },
            bottomBar = { BottomNavBar(navController, currentRoute) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Search Bar
                OutlinedTextField(
                    value = searchQuery.value,
                    onValueChange = { searchQuery.value = it },
                    label = { Text("Search Favorite by number or title") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                if (filteredHymns.isEmpty()) {
                    Text(
                        text = "No hymns found for the search query.\n ${searchQuery.value}",
//                        text = "No hymns found for the search query\n +.${searchQuery.value}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    FavHymnListScreen(navController, filteredHymns)
                }

            }
        }
    }
}

@Composable
fun FavHymnListScreen(
    navController: NavController,
    hymns: List<Hymn>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        items(hymns) { hymn ->
            FavHymnListItem(hymn = hymn, onItemClick = {
                navController.navigate("${Screens.HymnDetailScreen.route}/${hymn.number}")
            })
        }
    }
}

@Composable
fun FavHymnListItem(hymn: Hymn, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            // Number Badge
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .padding(4.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${hymn.number}",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = hymn.title.split(" ").joinToString(" ") { word ->
                    word.replaceFirstChar { it.uppercase() }
                },
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

