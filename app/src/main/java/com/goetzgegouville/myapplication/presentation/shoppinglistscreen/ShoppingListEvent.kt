package com.goetzgegouville.myapplication.presentation.shoppinglistscreen

import com.goetzgegouville.myapplication.data.models.ShoppingListItemEntity

sealed class ShoppingListEvent {
    data class OnShowDialog(val item: ShoppingListItemEntity)
}