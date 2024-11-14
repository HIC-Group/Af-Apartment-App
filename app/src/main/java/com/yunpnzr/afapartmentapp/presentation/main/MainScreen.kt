package com.yunpnzr.afapartmentapp.presentation.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.yunpnzr.afapartmentapp.common.component.BottomBar
import com.yunpnzr.afapartmentapp.common.navigation.BottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController,
                //modifier = modifier
            )
        }
    ) { _ ->
        BottomNavigation(
            modifier = modifier,
            navController = navController
        )
    }
}