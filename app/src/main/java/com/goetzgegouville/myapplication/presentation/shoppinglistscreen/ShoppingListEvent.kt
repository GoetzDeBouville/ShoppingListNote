package com.goetzgegouville.myapplication.presentation.shoppinglistscreen

import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import com.goetzgegouville.myapplication.utils.Routes

sealed class ShoppingListEvent {
    data class OnShowDeleteDialog(val item: ShoppingListItem) : ShoppingListEvent()
    data class OnShowEditDialog(val item: ShoppingListItem) : ShoppingListEvent()
    data class OnItemClick(val route: Routes) : ShoppingListEvent()
    data object OnItemSave : ShoppingListEvent()
}