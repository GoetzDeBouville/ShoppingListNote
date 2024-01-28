package com.goetzgegouville.myapplication.presentation.shoppinglistscreen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.goetzgegouville.myapplication.presentation.dialog.MainDialog
import com.goetzgegouville.myapplication.presentation.shoppinglistscreen.viewmodel.ShoppingListViewModel

@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    Text(
        text = "ShoppingList Screen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .wrapContentHeight()
    )
}