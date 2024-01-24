package com.goetzgegouville.myapplication.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.goetzgegouville.myapplication.R
import com.goetzgegouville.myapplication.ui.theme.GreenLight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            BottomNav()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = GreenLight,
                modifier = Modifier
                    .clip(CircleShape)
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
    }
}