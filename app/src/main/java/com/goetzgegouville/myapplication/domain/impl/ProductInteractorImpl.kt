package com.goetzgegouville.myapplication.domain.impl

import com.goetzgegouville.myapplication.domain.api.ProductDbConverter
import com.goetzgegouville.myapplication.domain.api.ProductInteractor
import com.goetzgegouville.myapplication.domain.api.ProductRepository
import com.goetzgegouville.myapplication.domain.api.ShoppingListDbConverter
import com.goetzgegouville.myapplication.domain.models.ProductItem
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductInteractorImpl(
    private val converterProduct: ProductDbConverter,
    private val converterShoppingListItem: ShoppingListDbConverter,
    private val repository: ProductRepository
) : ProductInteractor {
    override suspend fun insertProductToDb(item: ProductItem) {
        repository.insertProductToDb(converterProduct.map(item))
    }

    override suspend fun removeProductFromDb(item: ProductItem) {
        repository.removeProductFromDb(converterProduct.map(item))
    }

    override fun getProductListElementsByListId(listId: Int): Flow<List<ProductItem>> {
        return repository.getProductListElementsByListId(listId).map { list ->
            list.map {
                converterProduct.map(it)
            }
        }
    }

    override suspend fun getShopingListItemById(listId: Int): ShoppingListItem {
        return converterShoppingListItem.map(repository.getShopingListItemById(listId))
    }

    override suspend fun updateListToDb(item: ShoppingListItem) {
        repository.updateListToDb(converterShoppingListItem.map(item))
    }

}