package com.goetzgegouville.myapplication.domain.api

import com.goetzgegouville.myapplication.data.models.ProductItemEntity
import com.goetzgegouville.myapplication.data.models.ShoppingListItemEntity
import com.goetzgegouville.myapplication.domain.models.ProductItem
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import kotlinx.coroutines.flow.Flow

interface ProductInteractor {
    suspend fun insertProductToDb(item: ProductItem)

    suspend fun removeProductFromDb(item: ProductItem)

    fun getProductListElementsByListId(listId: Int): Flow<List<ProductItem>>

    suspend fun getShopingListItemById(listId: Int): ShoppingListItem

    suspend fun updateListToDb(item: ShoppingListItem)
}