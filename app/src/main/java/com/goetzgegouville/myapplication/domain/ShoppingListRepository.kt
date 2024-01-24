package com.goetzgegouville.myapplication.domain

import com.goetzgegouville.myapplication.data.ShoppingListItemEntity
import kotlinx.coroutines.flow.Flow

interface ShoppingListRepository {
    suspend fun insertListToDb(item: ShoppingListItemEntity)

    suspend fun removeListFromDb(item: ShoppingListItemEntity)

    fun getShopingListElements(): Flow<List<ShoppingListItemEntity>>
}