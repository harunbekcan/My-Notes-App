package com.harunbekcan.mynotesapp.data.repo

import androidx.lifecycle.LiveData
import com.harunbekcan.mynotesapp.data.entity.Note

interface NoteRepositoryInterface {

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun updateNote(note: Note)

    fun getNote() : LiveData<List<Note>>
}