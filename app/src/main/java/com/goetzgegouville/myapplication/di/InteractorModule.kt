package com.goetzgegouville.myapplication.di

import com.goetzgegouville.myapplication.domain.api.NoteDbConverter
import com.goetzgegouville.myapplication.domain.api.NoteInteractor
import com.goetzgegouville.myapplication.domain.api.NoteRepository
import com.goetzgegouville.myapplication.domain.api.ProductDbConverter
import com.goetzgegouville.myapplication.domain.api.ProductInteractor
import com.goetzgegouville.myapplication.domain.api.ProductRepository
import com.goetzgegouville.myapplication.domain.api.ShoppingListDbConverter
import com.goetzgegouville.myapplication.domain.api.ShoppingListInteractor
import com.goetzgegouville.myapplication.domain.api.ShoppingListRepository
import com.goetzgegouville.myapplication.domain.impl.NoteInteractorImpl
import com.goetzgegouville.myapplication.domain.impl.ProductInteractorImpl
import com.goetzgegouville.myapplication.domain.impl.ShoppingListInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class InteractorModule {
    @Provides
    fun provideNoteInteractor(
        converter: NoteDbConverter,
        repository: NoteRepository
    ): NoteInteractor = NoteInteractorImpl(converter, repository)

    @Provides
    fun provideProductInteractor(
        converterProduct: ProductDbConverter,
        converterShoppingListItem: ShoppingListDbConverter,
        repository: ProductRepository
    ): ProductInteractor = ProductInteractorImpl(
        converterProduct,
        converterShoppingListItem,
        repository
    )

    @Provides
    fun provideShoppingInteractor(
        converter: ShoppingListDbConverter,
        repository: ShoppingListRepository
    ): ShoppingListInteractor = ShoppingListInteractorImpl(
        converter,
        repository
    )
}