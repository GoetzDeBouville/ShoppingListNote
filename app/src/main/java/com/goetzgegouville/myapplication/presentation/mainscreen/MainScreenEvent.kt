package com.goetzgegouville.myapplication.presentation.mainscreen

sealed class MainScreenEvent {
    data object OnShowEditDialog : MainScreenEvent()
    data object OnItemSave : MainScreenEvent()
}
