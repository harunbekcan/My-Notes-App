package com.harunbekcan.mynotesapp.ui.fragment.newnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harunbekcan.mynotesapp.data.entity.Note
import com.harunbekcan.mynotesapp.data.repo.NoteRepository
import com.harunbekcan.mynotesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.IDN
import javax.inject.Inject

@HiltViewModel
class NewNoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    private var _noteMessage = MutableLiveData<Resource<Note>>()
    val noteMessage : LiveData<Resource<Note>> get() = _noteMessage

    private fun insertNote(note: Note) = viewModelScope.launch {
        noteRepository.insertNote(note)
    }

    fun addNote(title : String, description : String, id : Int) {
        if (title.isEmpty() || description.isEmpty()) {
            _noteMessage.postValue(Resource.error("Please fill in the blanks !!", null))
            return
        }
        val note = Note(title, description, id)
        insertNote(note)
        _noteMessage.postValue(Resource.success(note))
    }
}