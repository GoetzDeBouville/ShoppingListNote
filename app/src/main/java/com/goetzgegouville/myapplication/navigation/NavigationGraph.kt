package com.goetzgegouville.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.goetzgegouville.myapplication.presentation.aboutscreen.AboutScreen
import com.goetzgegouville.myapplication.presentation.notelistscreen.NoteListScreen
import com.goetzgegouville.myapplication.presentation.settingsscreen.SettingsScreen
import com.goetzgegouville.myapplication.presentation.shoppinglistscreen.ui.ShoppingListScreen
import com.goetzgegouville.myapplication.utils.Routes

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.SHOPPING_LIST) {
        composable(Routes.SHOPPING_LIST) {
            ShoppingListScreen()
        }
        composable(Routes.NOTE_LIST) {
            NoteListScreen()
        }
        composable(Routes.ABOUT) {
            AboutScreen()
        }
        composable(Routes.SETTINGS) {
            SettingsScreen()
        }
    }
}