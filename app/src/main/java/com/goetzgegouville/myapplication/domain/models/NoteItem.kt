package com.goetzgegouville.myapplication.domain.models

data class NoteItem(
    val id: Int? = null,
    val title: String,
    val description: String,
    val date: String
)
