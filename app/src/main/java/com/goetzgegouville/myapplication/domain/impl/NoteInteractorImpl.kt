package com.goetzgegouville.myapplication.domain.impl

import com.goetzgegouville.myapplication.domain.api.NoteDbConverter
import com.goetzgegouville.myapplication.domain.api.NoteInteractor
import com.goetzgegouville.myapplication.domain.api.NoteRepository
import com.goetzgegouville.myapplication.domain.models.NoteItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteInteractorImpl(
    private val converter: NoteDbConverter,
    private val repository: NoteRepository
) : NoteInteractor {
    override suspend fun insertNoteToDb(item: NoteItem) {
        repository.insertNoteToDb(converter.map(item))
    }

    override suspend fun removeNoteFromDb(item: NoteItem) {
        repository.removeNoteFromDb(converter.map(item))
    }

    override fun getNoteListElements(): Flow<List<NoteItem>> {
        return repository.getNoteListElements().map { list ->
            list.map {
                converter.map(it)
            }
        }
    }

    override suspend fun getNoteItemById(noteId: Int): NoteItem =
        converter.map(repository.getNoteItemById(noteId))
}