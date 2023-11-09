package com.example.dotapage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.dotapage.ui.screens.DotaScreen
import com.example.dotapage.ui.theme.AppTheme
import com.example.dotapage.ui.theme.DotaPageTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            DotaPageTheme {
                MainScreen()
            }
        }
    }
}

@Composable
private fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
        systemUiController.setNavigationBarColor(color = Color.Transparent)
    }
}

@Preview
@Composable
fun MainScreen() {
    DotaPageTheme {
        ApplySystemBarColors()
        // A surface container using the 'background' color from the theme
        Surface(
            color = AppTheme.BgColors.primary,
            modifier = Modifier.fillMaxSize(),
        ) {
            DotaScreen()
        }
    }
}