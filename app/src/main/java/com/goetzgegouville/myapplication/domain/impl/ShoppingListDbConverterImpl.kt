package com.goetzgegouville.myapplication.domain.impl

import com.goetzgegouville.myapplication.data.models.ShoppingListItemEntity
import com.goetzgegouville.myapplication.domain.api.ShoppingListDbConverter
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem

class ShoppingListDbConverterImpl : ShoppingListDbConverter {
    override fun map(dbEntity: ShoppingListItemEntity) = with(dbEntity) {
        ShoppingListItem(id, name, time, allItemsNumber, selectedItemsNumber)
    }

    override fun map(item: ShoppingListItem) = with(item) {
        ShoppingListItemEntity(id, name, time, allItemsNumber, selectedItemsNumber)
    }
}