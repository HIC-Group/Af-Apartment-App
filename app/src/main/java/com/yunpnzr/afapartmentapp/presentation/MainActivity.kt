package com.yunpnzr.afapartmentapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.yunpnzr.afapartmentapp.common.screen.AppNavigation
import com.yunpnzr.afapartmentapp.common.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SetBarColors()
                    /*Greeting(
                        name = "android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    //LoginScreen(modifier = Modifier.padding(innerPadding) )
                    //RegisterScreen(modifier = Modifier.padding(innerPadding))

                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

//for change text status bar (if you want)
@Composable
fun SetBarColors() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val statusBarLight = MaterialTheme.colorScheme.primary
    val statusBarDark = MaterialTheme.colorScheme.primary

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setStatusBarColor(
            color = if (useDarkIcons) statusBarLight else statusBarDark,
            darkIcons = if (useDarkIcons) false else false
        )
        onDispose { }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("android")
    }
}