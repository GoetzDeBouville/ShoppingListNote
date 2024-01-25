package com.goetzgegouville.myapplication.domain.impl

import com.goetzgegouville.myapplication.domain.api.ShoppingListDbConverter
import com.goetzgegouville.myapplication.domain.api.ShoppingListInteractor
import com.goetzgegouville.myapplication.domain.api.ShoppingListRepository
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ShoppingListInteractorImpl(
    private val converter: ShoppingListDbConverter,
    private val repository: ShoppingListRepository
) : ShoppingListInteractor {
    override suspend fun insertListToDb(item: ShoppingListItem) {
        repository.insertListToDb(converter.map(item))
    }

    override suspend fun removeListFromDb(item: ShoppingListItem) {
        repository.removeListFromDb(converter.map(item))
    }

    override fun getShopingListElements(): Flow<List<ShoppingListItem>> {
        return repository.getShopingListElements().map { list ->
            list.map {
                converter.map(it)
            }
        }
    }
}
