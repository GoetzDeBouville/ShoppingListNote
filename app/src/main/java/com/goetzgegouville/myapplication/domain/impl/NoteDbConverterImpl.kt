package com.goetzgegouville.myapplication.domain.impl

import com.goetzgegouville.myapplication.data.models.NoteItemEntity
import com.goetzgegouville.myapplication.domain.api.NoteDbConverter
import com.goetzgegouville.myapplication.domain.models.NoteItem

class NoteDbConverterImpl : NoteDbConverter {
    override fun map(dbEntity: NoteItemEntity) = with(dbEntity) {
        NoteItem(id, title, description, date)
    }

    override fun map(item: NoteItem) = with(item) {
        NoteItemEntity(id, title, description, date)
    }
}