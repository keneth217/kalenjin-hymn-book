package com.keneth.hymnbook

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay


@Composable
fun AboutScreen(
    navController: NavController,
    modifier: Modifier = Modifier,


    ) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val currentRoute =
        navController.currentBackStackEntry?.destination?.route ?: Screens.HymnScreen.route
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                AppDrawer(
                    drawerState,
                    scope,
                    onItemClick = { route -> navController.navigate(route) },
                    currentRoute = currentRoute

                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopBar(scope, drawerState, "About", onBottomSheetOpen = {})
            },
            bottomBar = { BottomNavBar(navController, currentRoute) }
        ) { innerPadding ->
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                AboutContentScreen(navController)
            }
        }
    }
}

@Composable
fun AboutContentScreen(navController: NavHostController) {
    val DarkPink = Color(0xFFe496ee)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TIENWOGIK CHE KILOSUNEN JEHOVAH",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.hymnbook),
                contentDescription = "App Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(400.dp)
                    .clip(CircleShape)
                    .padding(top = 20.dp, bottom = 20.dp)
                    .shadow(16.dp, shape = CircleShape)
            )
///version text
            Text(
                text = " Version 1.0",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )

        }

        // Developer credit at bottom

        FooterText(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
//        Text(
//            text = "Designed and Developed by Keneth Kipyegon\n + https://www.kipyegonkeneth.co.ke",
//            color = Color.White.copy(alpha = 0.8f),
//            style = MaterialTheme.typography.bodySmall,
//            fontStyle = FontStyle.Italic,
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(8.dp)
//        )
    }
}

    @Composable
    fun FooterText(modifier: Modifier) {
        val annotatedString = buildAnnotatedString {
            append("Designed and Developed by Keneth Kipyegon\n")

            // Add the clickable URL part
            withStyle(SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
                append("https://www.kipyegonkeneth.co.ke")
            }

            // Create a hyperlink action
            addStringAnnotation(
                tag = "URL",
                annotation = "https://www.kipyegonkeneth.co.ke",
                start = length - "https://www.kipyegonkeneth.co.ke".length,
                end = length
            )
        }

        val context = LocalContext.current

        ClickableText (
            text = annotatedString,
            style = TextStyle(fontSize = 16.sp),
            onClick = { offset ->
                annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                        context.startActivity(intent)
                    }
            },
           modifier = modifier.fillMaxSize().padding(10.dp)

        )
    }




