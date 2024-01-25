package com.goetzgegouville.myapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.goetzgegouville.myapplication.data.models.NoteItemEntity
import com.goetzgegouville.myapplication.data.models.ProductItemEntity
import com.goetzgegouville.myapplication.data.models.ShoppingListItemEntity

@Database(
    entities = [ShoppingListItemEntity::class, NoteItemEntity::class, ProductItemEntity::class],
    version = 1
)
abstract class MainDb : RoomDatabase() {
    abstract val shoppingListDao: ShoppingListItemDao
    abstract val productItemDao: ProductItemDao
    abstract val noteItemDao: NoteItemDao
}