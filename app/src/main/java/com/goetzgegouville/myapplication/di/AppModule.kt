package com.goetzgegouville.myapplication.di

import android.app.Application
import androidx.room.Room
import com.goetzgegouville.myapplication.data.db.MainDb
import com.goetzgegouville.myapplication.data.impl.NoteRepositoryImpl
import com.goetzgegouville.myapplication.data.impl.ProductRepositoryImpl
import com.goetzgegouville.myapplication.data.impl.ShoppingListRepositoryImpl
import com.goetzgegouville.myapplication.domain.NoteRepository
import com.goetzgegouville.myapplication.domain.ProductRepository
import com.goetzgegouville.myapplication.domain.ShoppingListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "shop_list_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideShopRepo(db: MainDb): ShoppingListRepository {
        return ShoppingListRepositoryImpl(db.shoppingListDao)
    }

    @Provides
    @Singleton
    fun provideProductRepo(db: MainDb): ProductRepository {
        return ProductRepositoryImpl(db.productItemDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepo(db: MainDb): NoteRepository {
        return NoteRepositoryImpl(db.noteItemDao)
    }
}