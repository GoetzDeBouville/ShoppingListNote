package com.goetzgegouville.myapplication.data.impl

import androidx.room.util.getColumnIndexOrThrow
import com.goetzgegouville.myapplication.data.ProductItemEntity
import com.goetzgegouville.myapplication.data.ShoppingListItemEntity
import com.goetzgegouville.myapplication.data.db.ProductItemDao
import com.goetzgegouville.myapplication.domain.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(private val dao: ProductItemDao) : ProductRepository {
    override suspend fun insertProductToDb(item: ProductItemEntity) {
        dao.insertProductToDb(item)
    }

    override suspend fun removeProductFromDb(item: ProductItemEntity) {
        dao.removeProductFromDb(item)
    }

    override fun getProductListElementsByListId(listId: Int): Flow<List<ProductItemEntity>> {
        return dao.getProductListElementsByListId(listId)
    }

    override suspend fun getShopingListItemById(listId: Int): ShoppingListItemEntity {
        return dao.getShopingListItemById(listId)
    }

    override suspend fun updateListToDb(item: ShoppingListItemEntity) {
        dao.updateListToDb(item)
    }

}