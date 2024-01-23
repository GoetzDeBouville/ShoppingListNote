package com.goetzgegouville.myapplication.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.goetzgegouville.myapplication.data.ShoppingListItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListItemDao {
    @Upsert
    suspend fun insertListToDb(item: ShoppingListItemEntity)

    @Delete
    suspend fun removeListFromDb(item: ShoppingListItemEntity)

    @Query("SELECT * FROM shopping_list_name")
    fun getShopingListElements(): Flow<List<ShoppingListItemEntity>>
}