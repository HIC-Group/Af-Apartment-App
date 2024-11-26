package com.yunpnzr.afapartmentapp.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yunpnzr.afapartmentapp.common.navigation.BottomNavItem
import com.yunpnzr.afapartmentapp.common.ui.theme.AppTheme
import com.yunpnzr.afapartmentapp.utils.topBorder

@Composable
fun BottomBar(
    navController: NavController,
    //modifier: Modifier = Modifier,
    //onItemClick: (BottomNavItem) -> Unit
){
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.History,
        BottomNavItem.Messages,
        BottomNavItem.Profile
    )

    val borderTopColor = MaterialTheme.colorScheme.outline

    NavigationBar(
        modifier = Modifier
            .topBorder(
                strokeWidth = 2.dp,
                color = borderTopColor
            )
            .fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination?.route

        items.map { item ->
            NavigationBarItem(
                selected = item.route == currentDestination,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    if (item.route == currentDestination) {
                        Text(text = item.title)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = MaterialTheme.colorScheme.secondary,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview(){
    AppTheme {
        BottomBar(
            navController = rememberNavController()
        )
    }
}