package com.goetzgegouville.myapplication.domain

import com.goetzgegouville.myapplication.data.ProductItemEntity
import com.goetzgegouville.myapplication.data.ShoppingListItemEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun insertProductToDb(item: ProductItemEntity)

    suspend fun removeProductFromDb(item: ProductItemEntity)

    fun getProductListElementsByListId(listId: Int): Flow<List<ProductItemEntity>>

    suspend fun getShopingListItemById(listId: Int): ShoppingListItemEntity

    suspend fun updateListToDb(item: ShoppingListItemEntity)
}