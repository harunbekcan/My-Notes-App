package com.harunbekcan.mynotesapp.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.harunbekcan.mynotesapp.data.entity.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM notes")
    fun observeNotes(): LiveData<List<Note>>
}