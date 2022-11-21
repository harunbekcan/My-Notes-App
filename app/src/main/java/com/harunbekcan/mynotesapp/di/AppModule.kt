package com.harunbekcan.mynotesapp.di

import android.content.Context
import androidx.room.Room
import com.harunbekcan.mynotesapp.data.repo.NoteRepository
import com.harunbekcan.mynotesapp.data.repo.NoteRepositoryInterface
import com.harunbekcan.mynotesapp.roomdb.NoteDao
import com.harunbekcan.mynotesapp.roomdb.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, NoteDatabase::class.java,"NoteDB").build()

    @Singleton
    @Provides
    fun provideDao(database: NoteDatabase) = database.noteDao()

    @Singleton
    @Provides
    fun provideNoteRepository(dao : NoteDao) = NoteRepository(dao) as NoteRepositoryInterface

}