package com.keneth.hymnbook

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HymnDetailScreen(
    hymnNumber: Int,
    navController: NavController
) {
    val hymn = remember(hymnNumber) { HymnRepository.getHymnByNumber(hymnNumber) }
    var fontSize by remember { mutableStateOf(20.sp) }
    var showDialog by remember { mutableStateOf(false) }
    var sliderPosition by remember { mutableFloatStateOf(fontSize.value) }
    var isFavourite by remember { mutableStateOf(hymn?.isFavourite ?: false) }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        hymn?.title ?: "",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { showDialog = true }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Adjust text size")
                    }
                    IconButton(onClick = { isFavourite = !isFavourite }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Add to favorites",
                            tint = if (isFavourite) Color.Red else MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    IconButton(onClick = {
                        val shareText = buildString {
                            append("${hymn?.number}: ${hymn?.title}\n\n")
                            hymn?.stanzas?.forEachIndexed { index, stanza ->
                                append("${index + 1}. $stanza\n\n")
                            }
                            if (!hymn?.chorus.isNullOrEmpty()) {
                                append("Chorus:\n${hymn?.chorus}\n")
                            }
                        }
                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, shareText)
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "Share Hymn"))
                    }) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "Share hymn")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding ->
        hymn?.let { safeHymn ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${safeHymn.number}: ${safeHymn.title}",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color(0xFFFFA500),
                    modifier = Modifier.padding(16.dp)
                )
                safeHymn.stanzas.forEachIndexed { index, stanza ->
                    Text(
                        text = "${index + 1}. $stanza",
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        fontSize = fontSize
                    )
                    if (index == 0 && safeHymn.chorus.isNotEmpty()) {
                        Text(
                            text = safeHymn.chorus,
                            color = Color(0xFFFFA500),
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .background(
                                    color = Color(0xFFFFA500).copy(alpha = 0.1f),
                                    shape = RoundedCornerShape(2.dp)
                                )
                                .padding(8.dp),
                            fontStyle = FontStyle.Italic,
                            fontSize = fontSize
                        )
                    }
                }
            }
        } ?: run {
            Box(modifier = Modifier.fillMaxSize()) {
                Text("Hymn not found", modifier = Modifier.align(Alignment.Center))
            }
        }
    }

    FontSizeDialog(
        showDialog = showDialog,
        onDismissRequest = { showDialog = false },
        sliderPosition = sliderPosition,
        onSliderValueChange = {
            sliderPosition = it
            fontSize = it.roundToInt().sp
        }
    )
}

@Composable
private fun FontSizeDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    sliderPosition: Float,
    onSliderValueChange: (Float) -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text("Adjust Text Size") },
            text = {
                Column {
                    Text("Font size: ${sliderPosition.toInt()} sp")
                    Spacer(modifier = Modifier.height(8.dp))
                    Slider(
                        value = sliderPosition,
                        onValueChange = onSliderValueChange,
                        valueRange = 14f..30f,
                        steps = 10,
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.colorScheme.secondary,
                            activeTrackColor = MaterialTheme.colorScheme.secondary,
                            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = onDismissRequest) {
                    Text("Done")
                }
            }
        )
    }
}


