package com.goetzgegouville.myapplication.presentation.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.goetzgegouville.myapplication.R
import com.goetzgegouville.myapplication.navigation.NavigationGraph
import com.goetzgegouville.myapplication.presentation.dialog.MainDialog
import com.goetzgegouville.myapplication.presentation.mainscreen.viewmodel.MainScreenViewModel
import com.goetzgegouville.myapplication.presentation.shoppinglistscreen.viewmodel.ShoppingListViewModel
import com.goetzgegouville.myapplication.ui.theme.LightGreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNav(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          viewModel.onEvent(MainScreenEvent.OnShowEditDialog)
                },
                containerColor = LightGreen,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_24),
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) {
        NavigationGraph(navController)
        MainDialog(viewModel)
    }
}