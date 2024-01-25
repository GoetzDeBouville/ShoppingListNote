package com.goetzgegouville.myapplication.domain.models

data class ShoppingListItem(
    val id: Int? = null,
    val name: String,
    val time: String,
    val allItemsNumber: Int,
    val selectedItemsNumber: Int
)
