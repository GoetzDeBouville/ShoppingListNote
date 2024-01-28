package com.goetzgegouville.myapplication.presentation.shoppinglistscreen.viewmodel

import android.widget.Toast
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goetzgegouville.myapplication.domain.api.ShoppingListInteractor
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import com.goetzgegouville.myapplication.presentation.dialog.DialogController
import com.goetzgegouville.myapplication.presentation.dialog.DialogEvent
import com.goetzgegouville.myapplication.presentation.shoppinglistscreen.ShoppingListEvent
import com.goetzgegouville.myapplication.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val interactor: ShoppingListInteractor
) : ViewModel(), DialogController {
    val list = interactor.getShopingListElements()
    private var listItem: ShoppingListItem? = null
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    override var dialogTitle = mutableStateOf("")
        private set
    override var editTableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(false)
        private set

    override fun onDialogEvent(event: DialogEvent) {
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

    fun onEvent(event: ShoppingListEvent) {
        when (event) {
            is ShoppingListEvent.OnItemSave -> {
                if (editTableText.value.isEmpty()) return

                viewModelScope.launch {
                    interactor.insertListToDb(
                        ShoppingListItem(
                            listItem?.id,
                            editTableText.value,
                            listItem?.time ?: "",
                            listItem?.allItemsNumber ?: 0,
                            listItem?.selectedItemsNumber ?: 0
                        )
                    )
                }
            }

            is ShoppingListEvent.OnItemClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }

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

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}