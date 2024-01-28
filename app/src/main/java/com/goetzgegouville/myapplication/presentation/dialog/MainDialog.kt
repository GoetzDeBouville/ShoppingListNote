package com.goetzgegouville.myapplication.presentation.dialog

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goetzgegouville.myapplication.ui.theme.BlackText
import com.goetzgegouville.myapplication.ui.theme.GrayBorder
import com.goetzgegouville.myapplication.ui.theme.GrayText
import com.goetzgegouville.myapplication.ui.theme.LightGray
import com.goetzgegouville.myapplication.ui.theme.LightGreen
import com.goetzgegouville.myapplication.ui.theme.Red

@Composable
fun MainDialog(dialogController: DialogController) {
    var isTextFieldFocused = false
    var inputText by remember { mutableStateOf("") }
    if (dialogController.openDialog.value) {
        AlertDialog(
            modifier = Modifier
                .border(1.dp, BlackText, RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            onDismissRequest = {
                dialogController.onDialogEvent(DialogEvent.OnCancel)
            },
            buttons = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            dialogController.onDialogEvent(DialogEvent.OnCancel)
                        },
                        modifier = Modifier
                            .padding(0.dp, 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Red
                        )
                    ) {
                        Text(text = "Cancel")
                    }
                    TextButton(
                        onClick = {
                            dialogController.onDialogEvent(DialogEvent.OnConfirm)
                        },
                        modifier = Modifier
                            .padding(0.dp, 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = if (inputText.isEmpty()) {
                                BlackText
                            } else {
                                LightGreen
                            }
                        )
                    ) {
                        Text(text = "OK")
                    }
                }
            },
            title = { null },
            text = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = dialogController.dialogTitle.value,
                        color = BlackText,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (dialogController.showEditableText.value) {
                        TextField(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = if (isTextFieldFocused) LightGreen else GrayBorder,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .onFocusChanged {
                                    isTextFieldFocused = it.isFocused
                                },
                            value = dialogController.editTableText.value,
                            onValueChange = { input ->
                                inputText = input
                                dialogController.onDialogEvent(DialogEvent.OnTextChange(input))
                            },
                            label = {
                                Text(
                                    text = "Input name"
                                )
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = LightGray,
                                textColor = BlackText,
                                cursorColor = LightGreen,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedLabelColor = LightGreen,
                                unfocusedLabelColor = GrayText
                            )
                        )
                    }
                }
            }
        )
    }
}