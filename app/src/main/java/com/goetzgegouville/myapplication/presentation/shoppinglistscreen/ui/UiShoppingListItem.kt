package com.goetzgegouville.myapplication.presentation.shoppinglistscreen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.goetzgegouville.myapplication.R
import com.goetzgegouville.myapplication.domain.models.ShoppingListItem
import com.goetzgegouville.myapplication.ui.theme.BlackText
import com.goetzgegouville.myapplication.ui.theme.GrayText
import com.goetzgegouville.myapplication.ui.theme.Green
import com.goetzgegouville.myapplication.ui.theme.LightGreen
import com.goetzgegouville.myapplication.ui.theme.LightYellow
import com.goetzgegouville.myapplication.ui.theme.Red
import com.goetzgegouville.myapplication.ui.theme.Salad
import com.goetzgegouville.myapplication.ui.theme.Yellow
import kotlin.random.Random

@Composable
fun UiShoppingListItem(
    item: ShoppingListItem
) {
    val progress = Random.nextFloat()
//                   val progress = item.selectedItemsNumber.toFloat() / item.allItemsNumber
    ConstraintLayout(
        modifier = Modifier.padding(
            4.dp,
            16.dp,
            4.dp,
            0.dp
        )
    ) {
        val (
            card,
            deleteButton,
            editButton,
            counter
        ) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = item.name,
                    style = TextStyle(
                        color = BlackText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                )
                Text(
                    text = item.time,
                    style = TextStyle(
                        color = GrayText,
                        fontSize = 12.sp
                    )
                )
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    progress = progress,
                    color = if (progress <= 0.3) {
                        Red
                    } else if (progress > 0.3 && progress < 0.5) {
                        LightYellow
                    } else if (progress == 1.0f) {
                        LightGreen
                    } else {
                        Salad
                    }
                )
            }
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(deleteButton) {
                    bottom.linkTo(card.top)
                    top.linkTo(card.top)
                    end.linkTo(card.end)
                }
                .padding(4.dp)
                .size(28.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_remove_24),
                contentDescription = "delete_icon",
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Red)
                    .padding(4.dp),
                tint = Color.White
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(editButton) {
                    bottom.linkTo(card.top)
                    top.linkTo(card.top)
                    end.linkTo(deleteButton.start)
                }
                .padding(4.dp)
                .size(28.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_edit_24),
                contentDescription = "edit_button",
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Green)
                    .padding(4.dp),
                tint = Color.White
            )
        }

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .constrainAs(counter) {
                    bottom.linkTo(editButton.bottom)
                    top.linkTo(editButton.top)
                    end.linkTo(editButton.start)
                }
                .padding(4.dp)
        ) {
            Text(
                text = "${item.allItemsNumber}/${item.selectedItemsNumber}",
                modifier = Modifier
                    .background(Yellow)
                    .padding(4.dp, 4.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}