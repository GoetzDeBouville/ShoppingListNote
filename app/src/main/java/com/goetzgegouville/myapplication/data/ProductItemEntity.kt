package com.goetzgegouville.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ProductItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val isChecked: Boolean,
    val listId: Int
)