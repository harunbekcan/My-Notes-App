package com.harunbekcan.mynotesapp.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harunbekcan.mynotesapp.data.entity.Note
import com.harunbekcan.mynotesapp.data.repo.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyNotesViewModel @Inject constructor (private val repository: NoteRepository) : ViewModel() {

    val noteList = repository.getNote()

    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }
}