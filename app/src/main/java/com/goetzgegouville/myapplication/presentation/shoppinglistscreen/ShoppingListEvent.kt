package com.goetzgegouville.myapplication.presentation.shoppinglistscreen

import com.goetzgegouville.myapplication.domain.models.ShoppingListItem

sealed class ShoppingListEvent {
    data class OnShowDeleteDialog(val item: ShoppingListItem) : ShoppingListEvent()
    data class OnShowEditDialog(val item: ShoppingListItem) : ShoppingListEvent()
    data class OnItemClick(val item: ShoppingListItem) : ShoppingListEvent()
    data object OnSave : ShoppingListEvent()
}