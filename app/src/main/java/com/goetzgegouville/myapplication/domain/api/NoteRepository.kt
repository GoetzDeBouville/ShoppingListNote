package com.goetzgegouville.myapplication.domain.api

import androidx.room.Delete
import com.goetzgegouville.myapplication.data.models.NoteItemEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertNoteToDb(item: NoteItemEntity)

    suspend fun removeNoteFromDb(item: NoteItemEntity)

    fun getNoteListElements(): Flow<List<NoteItemEntity>>

    suspend fun getNoteItemById(noteId: Int): NoteItemEntity
}