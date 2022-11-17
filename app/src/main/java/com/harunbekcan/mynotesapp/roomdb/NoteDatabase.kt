package com.harunbekcan.mynotesapp.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.harunbekcan.mynotesapp.data.entity.Note

@Database(entities = [Note::class],version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
}