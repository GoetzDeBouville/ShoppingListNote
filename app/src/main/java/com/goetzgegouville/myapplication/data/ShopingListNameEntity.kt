package com.goetzgegouville.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_list_name")
data class ShopingListNameEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val time: String,
    val allItemsNumber: Int,
    val selectedItemsNumber: Int
)
