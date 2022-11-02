package com.catnip.notepadku.data.room.dao

import androidx.room.*
import com.catnip.notepadku.data.room.entity.Note

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
@Dao
interface NotesDao {

    @Query("SELECT * FROM NOTES")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT * FROM NOTES WHERE category_id == :categoryId")
    suspend fun getNotesByCategoryId(categoryId: Int): List<Note>

    @Query("SELECT * FROM NOTES WHERE id == :id")
    suspend fun getNoteById(id: Int): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note: List<Note>)

    @Delete
    suspend fun deleteNote(note : Note) : Int

    @Update
    suspend fun updateNote(note : Note) : Int

}