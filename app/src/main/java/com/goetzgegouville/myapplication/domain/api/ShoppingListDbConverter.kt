package com.goetzgegouville.myapplication.domain.api

import com.goetzgegouville.myapplication.data.models.ShoppingListItemEntity
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem

interface ShoppingListDbConverter {
    fun map(dbEntity: ShoppingListItemEntity): ShoppingListItem
    fun map(item: ShoppingListItem): ShoppingListItemEntity
}