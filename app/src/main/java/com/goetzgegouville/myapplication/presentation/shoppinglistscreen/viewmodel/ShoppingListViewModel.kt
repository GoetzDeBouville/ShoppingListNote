package com.goetzgegouville.myapplication.presentation.shoppinglistscreen.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goetzgegouville.myapplication.domain.api.ShoppingListInteractor
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import com.goetzgegouville.myapplication.presentation.dialog.DialogEvent
import com.goetzgegouville.myapplication.presentation.shoppinglistscreen.ShoppingListEvent
import com.goetzgegouville.myapplication.utils.DialogController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val interactor: ShoppingListInteractor
) : ViewModel(), DialogController {
    private val list = interactor.getShopingListElements()
    private var listItem: ShoppingListItem? = null

    override var dialogTitle = mutableStateOf("")
        private set

    override var editTableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(false)
        private set

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
            is ShoppingListEvent.OnShowDeleteDialog -> {
                listItem = event.item
                openDialog.value = true
                dialogTitle.value = "Delete this item?"
                showEditableText.value = false
            }
            is ShoppingListEvent.OnShowEditDialog -> {
                listItem = event.item
                openDialog.value = true
                editTableText.value = listItem?.name ?: ""
                dialogTitle.value = "List: ${listItem?.name ?: ""}"
                showEditableText.value = true
            }
        }
    }

    fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnCancel -> openDialog.value = false
            is DialogEvent.OnConfirm -> {
                if (showEditableText.value) {
                    onEvent(ShoppingListEvent.OnItemSave)
                } else {
                    viewModelScope.launch {
                        listItem?.let { interactor.removeListFromDb(it) }
                    }
                }
                openDialog.value = false
            }
            is DialogEvent.OnTextChange -> editTableText.value = event.text
        }
    }
}