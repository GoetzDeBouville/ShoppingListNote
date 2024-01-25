package com.goetzgegouville.myapplication.data.impl

import com.goetzgegouville.myapplication.data.models.ShoppingListItemEntity
import com.goetzgegouville.myapplication.data.db.ShoppingListItemDao
import com.goetzgegouville.myapplication.domain.api.ShoppingListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ShoppingListRepositoryImpl(
    private val dao: ShoppingListItemDao
) : ShoppingListRepository {
    override suspend fun insertListToDb(item: ShoppingListItemEntity) {
        withContext(Dispatchers.IO) {
            dao.insertListToDb(item)
        }
    }

    override suspend fun removeListFromDb(item: ShoppingListItemEntity) {
        withContext(Dispatchers.IO) {
            dao.removeListFromDb(item)
        }
    }

    override fun getShopingListElements(): Flow<List<ShoppingListItemEntity>> {
        return dao.getShopingListElements()
    }
}