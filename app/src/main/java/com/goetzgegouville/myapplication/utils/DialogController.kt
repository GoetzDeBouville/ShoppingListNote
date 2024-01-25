package com.goetzgegouville.myapplication.utils

import androidx.compose.runtime.MutableState

interface DialogController {
    val dialogTitle: MutableState<String>
    val editTableText: MutableState<String>
    val openDialog: MutableState<Boolean>
    val showEditableText: MutableState<Boolean>
}