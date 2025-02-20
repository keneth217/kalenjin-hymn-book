package com.keneth.hymnbook

import android.window.SplashScreenView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val DarkPink = Color(0xFFe496ee)

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(Screens.HymnScreen.route) {
            popUpTo(Screens.SplashScreen.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkPink)
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
                    .size(300.dp)
                    .clip(CircleShape)
                    .padding(top = 20.dp, bottom = 20.dp)
                    .shadow(16.dp, shape = CircleShape)
            )

            Text(
                text = "\"Let the message of Christ dwell among you richly as you " +
                        "teach and admonish one another with all wisdom through " +
                        "psalms, hymns, and songs from the Spirit, " +
                        "singing to God with gratitude in your hearts.\"",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = "Colossians 3:16",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .padding(bottom=10.dp)
                    .align(Alignment.End)
            )

            Button(
                onClick = {
                    navController.navigate(Screens.HymnScreen.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.White
                )
            ) {
                Text("Get Started", style = MaterialTheme.typography.labelLarge)
            }
        }

        // Developer credit at bottom
        Text(
            text = "Designed and Developed by Keneth Kipyegon with moderation by Chelemei A.G.C",
            color = Color.White.copy(alpha = 0.8f),
            style = MaterialTheme.typography.bodySmall,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
fun SplashScreenView() {

    SplashScreen(navController = NavHostController(context = LocalContext.current))
}