package com.harunbekcan.mynotesapp.ui.fragment.mynotes

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.databinding.FragmentMyNotesBinding
import com.harunbekcan.mynotesapp.ui.adapter.MyNotesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyNotesFragment : BaseFragment<FragmentMyNotesBinding>() {

    private lateinit var myNotesAdapter: MyNotesAdapter
    private val viewModel: MyNotesViewModel by viewModels()
    override fun getLayoutId(): Int = R.layout.fragment_my_notes

    override fun prepareView(savedInstanceState: Bundle?) {
        initToolbar()
        createNewNoteButtonListener()
        initObservers()
    }

    private fun initToolbar() {
        binding.myNotesToolbar.apply {
            toolbarTitle.text = getString(R.string.my_notes)
        }
    }

    private fun createNewNoteButtonListener() {
        binding.createNewNoteButton.setOnClickListener {
            findNavController().navigate(MyNotesFragmentDirections.actionMyNotesFragmentToNewNoteFragment())
        }
    }

    private fun initObservers() {
        viewModel.noteList.observe(viewLifecycleOwner) {
            myNotesAdapter = MyNotesAdapter(
                it,
                itemClick = { findNavController().navigate(MyNotesFragmentDirections.actionMyNotesFragmentToNoteDetailFragment()) },
                deleteButtonClick = { deleteNote ->
                    viewModel.deleteNote(deleteNote)
                })
            binding.notesRecyclerView.adapter = myNotesAdapter
        }
    }
}