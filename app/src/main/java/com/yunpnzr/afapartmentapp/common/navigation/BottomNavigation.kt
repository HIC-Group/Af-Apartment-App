package com.yunpnzr.afapartmentapp.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.yunpnzr.afapartmentapp.presentation.main.history.HistoryScreen
import com.yunpnzr.afapartmentapp.presentation.main.home.HomeScreen
import com.yunpnzr.afapartmentapp.presentation.main.message.MessagesScreen
import com.yunpnzr.afapartmentapp.presentation.main.profile.ProfileScreen

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = BottomNavItem.Home.route
    ){
        composable(
            route = BottomNavItem.Home.route,
            content = {
                HomeScreen(modifier, navController)
            }
        )
        composable(
            route = BottomNavItem.History.route,
            content = {
                HistoryScreen(modifier, navController)
            }
        )
        composable(
            route = BottomNavItem.Messages.route,
            content = {
                MessagesScreen(modifier, navController)
            }
        )
        composable(
            route = BottomNavItem.Profile.route,
            content = {
                ProfileScreen(modifier, navController)
            }
        )
    }
}