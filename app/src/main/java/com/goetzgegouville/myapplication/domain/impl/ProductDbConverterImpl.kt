package com.goetzgegouville.myapplication.domain.impl

import com.goetzgegouville.myapplication.data.models.ProductItemEntity
import com.goetzgegouville.myapplication.domain.api.ProductDbConverter
import com.goetzgegouville.myapplication.domain.models.ProductItem

class ProductDbConverterImpl: ProductDbConverter {
    override fun map(dbEntity: ProductItemEntity) = with(dbEntity) {
        ProductItem(id, name, isChecked, listId)
    }

    override fun map(item: ProductItem) = with(item) {
        ProductItemEntity(id, name, isChecked, listId)
    }
}