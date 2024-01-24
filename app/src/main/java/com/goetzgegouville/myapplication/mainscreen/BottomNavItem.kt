package com.goetzgegouville.myapplication.mainscreen

import com.goetzgegouville.myapplication.R

sealed class BottomNavItem(
    val title: String,
    val iconId: Int,
    val route: String
) {
    data object ListItem : BottomNavItem("List", R.drawable.ic_checklist_24, "Route1")
    data object NoteItem : BottomNavItem("Note", R.drawable.ic_edit_note_24, "Route2")
    data object SettingsItem : BottomNavItem("Settings", R.drawable.ic_settings_24, "Route3")
    data object AboutItem : BottomNavItem("About", R.drawable.ic_info_24, "Route4")
}