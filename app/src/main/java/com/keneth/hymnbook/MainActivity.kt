package com.keneth.hymnbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.keneth.hymnbook.ui.theme.KALENJINHYMNBOOKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_MyApp)

      //  installSplashScreen() // Android 12+ built-in splash screen
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KALENJINHYMNBOOKTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HymnBookApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

