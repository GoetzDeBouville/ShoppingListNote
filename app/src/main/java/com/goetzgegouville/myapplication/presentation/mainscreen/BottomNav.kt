package com.goetzgegouville.myapplication.presentation.mainscreen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.goetzgegouville.myapplication.ui.theme.BottomNavColor
import com.goetzgegouville.myapplication.ui.theme.DefaultIconColor
import com.goetzgegouville.myapplication.ui.theme.GreenLight
import com.goetzgegouville.myapplication.ui.theme.LightBlue

@Composable
fun BottomNav(navController: NavHostController) {
    val listItems = listOf(
        BottomNavItem.ProductListItem,
        BottomNavItem.NoteItem,
        BottomNavItem.AboutItem,
        BottomNavItem.SettingsItem
    )

    BottomNavigation(backgroundColor = BottomNavColor) {
        listItems.forEach { bottomNavItem ->
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            BottomNavigationItem(
                selected = currentRoute == bottomNavItem.route,
                onClick = {
                          navController.navigate(bottomNavItem.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = bottomNavItem.iconId),
                        contentDescription = "icon"
                    )
                },
                label = {
                    Text(
                        text = bottomNavItem.title
                    )
                },
                selectedContentColor = GreenLight,
                unselectedContentColor = DefaultIconColor,
                alwaysShowLabel = false
            )
        }
    }
}