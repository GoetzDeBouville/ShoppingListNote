package com.goetzgegouville.myapplication.domain.api

import com.goetzgegouville.myapplication.data.models.ProductItemEntity
import com.goetzgegouville.myapplication.data.models.ShoppingListItemEntity
import kotlinx.coroutines.flow.Flow

interface ProductInteractor {
    suspend fun insertProductToDb(item: ProductItemEntity)

    suspend fun removeProductFromDb(item: ProductItemEntity)

    fun getProductListElementsByListId(listId: Int): Flow<List<ProductItemEntity>>

    suspend fun getShopingListItemById(listId: Int): ShoppingListItemEntity

    suspend fun updateListToDb(item: ShoppingListItemEntity)
}