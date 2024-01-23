package com.goetzgegouville.myapplication.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.goetzgegouville.myapplication.data.NoteItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteItemDao {
    @Upsert
    suspend fun insertNoteToDb(item: NoteItemEntity)

    @Delete
    suspend fun removeNoteFromDb(item: NoteItemEntity)

    @Query("SELECT * FROM notes_table")
    fun getNoteListElements(): Flow<List<NoteItemEntity>>

    @Query("SELECT * FROM notes_table WHERE id = :noteId")
    suspend fun getNoteItemById(noteId: Int): NoteItemEntity
}