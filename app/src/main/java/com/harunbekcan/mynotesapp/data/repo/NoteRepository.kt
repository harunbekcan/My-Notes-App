package com.harunbekcan.mynotesapp.data.repo

import androidx.lifecycle.LiveData
import com.harunbekcan.mynotesapp.data.entity.Note
import com.harunbekcan.mynotesapp.roomdb.NoteDao
import javax.inject.Inject

class NoteRepository @Inject constructor (private val noteDao: NoteDao) : NoteRepositoryInterface {

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    override fun getNote(): LiveData<List<Note>> {
        return noteDao.observeNotes()
    }

}