package com.goetzgegouville.myapplication.domain.api

import com.goetzgegouville.myapplication.data.models.ProductItemEntity
import com.goetzgegouville.myapplication.domain.models.ProductItem

interface ProductDbConverter {
    fun map(dbEntity: ProductItemEntity): ProductItem
    fun map(item: ProductItem): ProductItemEntity
}