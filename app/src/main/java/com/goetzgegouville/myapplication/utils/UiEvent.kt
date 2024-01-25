package com.goetzgegouville.myapplication.utils

sealed class UiEvent {
    data object PopBackStack : UiEvent()
    data class Navigate(val route: Routes) : UiEvent()
    data class ShowSnackBar(val message: String) : UiEvent()
}