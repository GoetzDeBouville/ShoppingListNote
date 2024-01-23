package com.goetzgegouville.myapplication.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.goetzgegouville.myapplication.data.ProductItemEntity
import com.goetzgegouville.myapplication.data.ShoppingListItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductItemDao {
    @Upsert
    suspend fun insertProductToDb(item: ProductItemEntity)

    @Delete
    suspend fun removeProductFromDb(item: ProductItemEntity)

    @Query("SELECT * FROM product_table WHERE listId = :listId")
    fun getProductListElementsByListId(listId: Int): Flow<List<ProductItemEntity>>

    @Query("SELECT * FROM shopping_list_name WHERE id = :listId")
    suspend fun getShopingListItemById(listId: Int): ShoppingListItemEntity

    @Update
    suspend fun updateListToDb(item: ShoppingListItemEntity)
}