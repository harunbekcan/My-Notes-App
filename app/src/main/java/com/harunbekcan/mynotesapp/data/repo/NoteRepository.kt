package com.harunbekcan.mynotesapp.data.repo

import com.harunbekcan.mynotesapp.roomdb.NoteDao
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
}