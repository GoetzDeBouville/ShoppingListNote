package com.goetzgegouville.myapplication.domain.api

import com.goetzgegouville.myapplication.data.models.NoteItemEntity
import com.goetzgegouville.myapplication.domain.models.NoteItem

interface NoteDbConverter {
    fun map(dbEntity: NoteItemEntity): NoteItem
    fun map(item: NoteItem): NoteItemEntity
}