package com.harunbekcan.mynotesapp.ui.fragment.updatenote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harunbekcan.mynotesapp.data.entity.Note
import com.harunbekcan.mynotesapp.data.repo.NoteRepository
import com.harunbekcan.mynotesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateNoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    private var _updateNoteMessage = MutableLiveData<Resource<Note>>()
    val updateNoteMessage : LiveData<Resource<Note>> get() = _updateNoteMessage

    private fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note)
    }

    fun updateMyNote(title : String, description : String,id : Int) {
        if (title.isEmpty() || description.isEmpty()) {
            _updateNoteMessage.postValue(Resource.error("Please fill in the blanks !!", null))
            return
        }
        val note = Note(title, description, id)
        updateNote(note)
        _updateNoteMessage.postValue(Resource.success(note))
    }
}