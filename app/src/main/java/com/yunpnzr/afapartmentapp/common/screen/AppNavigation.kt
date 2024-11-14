package com.yunpnzr.afapartmentapp.common.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yunpnzr.afapartmentapp.presentation.auth.forgetpassword.ForgetPasswordScreen
import com.yunpnzr.afapartmentapp.presentation.auth.login.LoginScreen
import com.yunpnzr.afapartmentapp.presentation.auth.register.RegisterScreen
import com.yunpnzr.afapartmentapp.presentation.main.MainScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navigationActions = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {
        composable(AppScreen.Login.route) {
            LoginScreen(modifier,navController)
        }
        composable(AppScreen.Register.route) {
            RegisterScreen(modifier, navController)
        }
        composable(AppScreen.ForgetPassword.route) {
            ForgetPasswordScreen(modifier, navController)
        }

        composable(AppScreen.Main.route) {
            MainScreen(modifier, navigationActions)
        }

    }
}