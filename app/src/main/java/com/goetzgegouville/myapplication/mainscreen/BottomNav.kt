package com.goetzgegouville.myapplication.mainscreen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.goetzgegouville.myapplication.ui.theme.BottomNavColor
import com.goetzgegouville.myapplication.ui.theme.DefaultIconColor
import com.goetzgegouville.myapplication.ui.theme.LightBlue

@Composable
fun BottomNav() {
    val listItems = listOf(
        BottomNavItem.ListItem,
        BottomNavItem.NoteItem,
        BottomNavItem.AboutItem,
        BottomNavItem.SettingsItem
    )

    BottomNavigation(backgroundColor = BottomNavColor) {
        listItems.forEach { bottomNavItem ->
            BottomNavigationItem(
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        painter = painterResource(id = bottomNavItem.iconId),
                        contentDescription = "icon",
                        tint = DefaultIconColor
                    )
                },
                label = {
                    Text(
                        text = bottomNavItem.title,
                        color = DefaultIconColor
                    )
                },
                selectedContentColor = LightBlue,
                unselectedContentColor = DefaultIconColor,
                alwaysShowLabel = false
            )
        }
    }
}