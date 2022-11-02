package com.catnip.notepadku.data.room.datasource

import com.catnip.notepadku.data.room.dao.NotesDao
import com.catnip.notepadku.data.room.entity.Note

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface NotesDataSource {
    suspend fun getAllNotes(): List<Note>

    suspend fun getNotesByCategoryId(categoryId: Int): List<Note>

    suspend fun getNoteById(id: Int): Note

    suspend fun insertNote(note: Note): Long

    suspend fun deleteNote(note: Note): Int

    suspend fun updateNote(note: Note): Int
}

class NotesDataSourceImpl(private val dao: NotesDao) : NotesDataSource {
    override suspend fun getAllNotes(): List<Note> {
        return dao.getAllNotes()
    }

    override suspend fun getNotesByCategoryId(categoryId: Int): List<Note> {
        return dao.getNotesByCategoryId(categoryId)
    }

    override suspend fun getNoteById(id: Int): Note {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note): Long {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note): Int {
        return dao.deleteNote(note)
    }

    override suspend fun updateNote(note: Note): Int {
        return dao.updateNote(note)
    }

}