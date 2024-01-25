package com.goetzgegouville.myapplication.domain.models

data class ProductItem(
    val id: Int? = null,
    val name: String,
    val isChecked: Boolean,
    val listId: Int
)