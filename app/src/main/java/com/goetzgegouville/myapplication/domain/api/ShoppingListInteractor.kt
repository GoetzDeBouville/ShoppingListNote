package com.goetzgegouville.myapplication.domain.api

import com.goetzgegouville.myapplication.data.models.ShoppingListItemEntity
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import kotlinx.coroutines.flow.Flow

interface ShoppingListInteractor {
    suspend fun insertListToDb(item: ShoppingListItem)

    suspend fun removeListFromDb(item: ShoppingListItem)

    fun getShopingListElements(): Flow<List<ShoppingListItem>>
}