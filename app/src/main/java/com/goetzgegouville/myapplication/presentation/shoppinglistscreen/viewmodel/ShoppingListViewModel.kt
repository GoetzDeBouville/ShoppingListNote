package com.goetzgegouville.myapplication.presentation.shoppinglistscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goetzgegouville.myapplication.domain.api.ShoppingListInteractor
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import com.goetzgegouville.myapplication.presentation.shoppinglistscreen.ShoppingListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val interactor: ShoppingListInteractor
) : ViewModel() {
    private var listItem: ShoppingListItem? = null
    fun onEvent(event: ShoppingListEvent) {
        when (event) {
            is ShoppingListEvent.OnItemSave -> {
                viewModelScope.launch {
                    interactor.insertListToDb(
                        ShoppingListItem(
                            listItem?.id,
                            listItem?.name ?: "",
                            listItem?.time ?: "",
                            listItem?.allItemsNumber ?: 0,
                            listItem?.selectedItemsNumber ?: 0
                        )
                    )
                }
            }

            is ShoppingListEvent.OnItemClick -> Unit
            is ShoppingListEvent.OnShowDeleteDialog -> listItem = event.item
            is ShoppingListEvent.OnShowEditDialog -> listItem = event.item
        }
    }
}