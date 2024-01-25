package com.goetzgegouville.myapplication.domain.api

import androidx.room.Delete
import com.goetzgegouville.myapplication.data.models.NoteItemEntity
import com.goetzgegouville.myapplication.domain.models.NoteItem
import kotlinx.coroutines.flow.Flow

interface NoteInteractor {
    suspend fun insertNoteToDb(item: NoteItem)

    suspend fun removeNoteFromDb(item: NoteItem)

    fun getNoteListElements(): Flow<List<NoteItem>>

    suspend fun getNoteItemById(noteId: Int): NoteItem
}