package com.goetzgegouville.myapplication.presentation.shoppinglistscreen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.goetzgegouville.myapplication.presentation.dialog.MainDialog
import com.goetzgegouville.myapplication.presentation.shoppinglistscreen.viewmodel.ShoppingListViewModel
import com.goetzgegouville.myapplication.ui.theme.LightGray

@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    val itemlist = viewModel.list.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = LightGray,
                shape = RoundedCornerShape(16.dp)
            ),
        contentPadding = PaddingValues(bottom = 64.dp)
    ) {
        items(itemlist.value) { item ->
            UiShoppingListItem(item) { event ->
                viewModel.onEvent(event)
            }
        }
    }
    MainDialog(viewModel)
}