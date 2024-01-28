package com.goetzgegouville.myapplication.presentation.mainscreen.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goetzgegouville.myapplication.domain.api.ShoppingListInteractor
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import com.goetzgegouville.myapplication.presentation.dialog.DialogController
import com.goetzgegouville.myapplication.presentation.dialog.DialogEvent
import com.goetzgegouville.myapplication.presentation.mainscreen.MainScreenEvent
import com.goetzgegouville.myapplication.presentation.shoppinglistscreen.ShoppingListEvent
import com.goetzgegouville.myapplication.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val interactor: ShoppingListInteractor
) : ViewModel(), DialogController {
    override var dialogTitle = mutableStateOf("List item:")
        private set
    override var editTableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(true)
        private set

    private val simpleDateFormat = SimpleDateFormat("dd/mm/yyyy HH:mm:ss", Locale.ENGLISH)
    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnCancel -> {
                openDialog.value = false
                editTableText.value = ""
            }
            is DialogEvent.OnConfirm -> {
                onEvent(MainScreenEvent.OnItemSave)
                openDialog.value = false
                editTableText.value = ""
            }
            is DialogEvent.OnTextChange -> editTableText.value = event.text
        }
    }

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnItemSave -> {
                if (editTableText.value.isEmpty()) return
                viewModelScope.launch {
                    interactor.insertListToDb(
                        ShoppingListItem(
                            null,
                            editTableText.value,
                            simpleDateFormat.format(System.currentTimeMillis()),
                            0,
                            0
                        )
                    )
                }
                editTableText.value = ""
            }
            is MainScreenEvent.OnShowEditDialog -> {
                openDialog.value = true
            }
        }
    }
}