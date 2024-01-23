package com.goetzgegouville.myapplication.domain

import androidx.room.Delete
import com.goetzgegouville.myapplication.data.NoteItemEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertNoteToDb(item: NoteItemEntity)

    @Delete
    suspend fun removeNoteFromDb(item: NoteItemEntity)

    fun getNoteListElements(): Flow<List<NoteItemEntity>>

    suspend fun getNoteItemById(noteId: Int): NoteItemEntity
}