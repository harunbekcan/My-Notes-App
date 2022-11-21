package com.harunbekcan.mynotesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.databinding.FragmentNewNoteBinding

class NewNoteFragment : BaseFragment<FragmentNewNoteBinding>() {

    private val viewModel : NewNoteViewModel by viewModels()
    override fun getLayoutId(): Int = R.layout.fragment_new_note

    override fun prepareView(savedInstanceState: Bundle?) {
        initToolbar()
        createNoteButtonListener()
    }

    private fun initToolbar(){
        binding.newNoteToolbar.apply {
            toolbarTitle.text = getString(R.string.create_note)
        }
    }

    private fun createNoteButtonListener(){
        binding.createNoteButton.setOnClickListener {
            viewModel.addNote(binding.noteTitleEditText.text.toString(), binding.noteDescriptionEditText.text.toString())
        }
    }
}