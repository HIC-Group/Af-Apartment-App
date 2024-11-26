package com.yunpnzr.afapartmentapp.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun StatusBarColors(){
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val statusBarLight = MaterialTheme.colorScheme.background
    val statusBarDark = MaterialTheme.colorScheme.background

    systemUiController.setStatusBarColor(
        color = if (useDarkIcons) statusBarLight else statusBarDark,
        darkIcons = useDarkIcons
    )
}

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