package com.harunbekcan.mynotesapp.di

import android.content.Context
import androidx.room.Room
import com.harunbekcan.mynotesapp.roomdb.NoteDatabase
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

object AppModule {

    @Singleton
    @Provides
    fun injectRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, NoteDatabase::class.java,"NoteDB").build()

    @Singleton
    @Provides
    fun injectDao(database: NoteDatabase) = database.noteDao()

}