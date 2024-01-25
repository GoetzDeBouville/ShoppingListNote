package com.goetzgegouville.myapplication.data.impl

import com.goetzgegouville.myapplication.data.models.NoteItemEntity
import com.goetzgegouville.myapplication.data.db.NoteItemDao
import com.goetzgegouville.myapplication.domain.api.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NoteItemDao) : NoteRepository {
    override suspend fun insertNoteToDb(item: NoteItemEntity) {
        dao.insertNoteToDb(item)
    }

    override suspend fun removeNoteFromDb(item: NoteItemEntity) {
        dao.removeNoteFromDb(item)
    }

    override fun getNoteListElements(): Flow<List<NoteItemEntity>> {
        return dao.getNoteListElements()
    }

    override suspend fun getNoteItemById(noteId: Int): NoteItemEntity {
        return dao.getNoteItemById(noteId)
    }
}