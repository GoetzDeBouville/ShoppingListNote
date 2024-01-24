package com.goetzgegouville.myapplication.presentation.mainscreen

import com.goetzgegouville.myapplication.R
import com.goetzgegouville.myapplication.utils.Routes

sealed class BottomNavItem(
    val title: String,
    val iconId: Int,
    val route: String
) {
    data object ProductListItem : BottomNavItem("List", R.drawable.ic_checklist_24, Routes.SHOPPING_LIST)
    data object NoteItem : BottomNavItem("Note", R.drawable.ic_edit_note_24, Routes.NOTE_LIST)
    data object SettingsItem : BottomNavItem("Settings", R.drawable.ic_settings_24, Routes.SETTINGS)
    data object AboutItem : BottomNavItem("About", R.drawable.ic_info_24, Routes.ABOUT)
}