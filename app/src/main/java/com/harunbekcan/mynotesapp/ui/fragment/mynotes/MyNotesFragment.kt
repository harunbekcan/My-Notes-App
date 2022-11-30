package com.harunbekcan.mynotesapp.ui.fragment.mynotes

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.data.entity.Note
import com.harunbekcan.mynotesapp.databinding.FragmentMyNotesBinding
import com.harunbekcan.mynotesapp.ui.adapter.MyNotesAdapter
import com.harunbekcan.mynotesapp.utils.setGone
import com.harunbekcan.mynotesapp.utils.setVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyNotesFragment : BaseFragment<FragmentMyNotesBinding>() {

    private lateinit var myNotesAdapter: MyNotesAdapter
    private val viewModel: MyNotesViewModel by viewModels()
    override fun getLayoutId(): Int = R.layout.fragment_my_notes

    override fun prepareView(savedInstanceState: Bundle?) {
        setToolbar()
        createNewNoteButtonListener()
        noteObserver()
    }

    private fun setToolbar() {
        binding.myNotesToolbar.apply {
            toolbarTitle.text = getString(R.string.my_notes)
        }
    }

    private fun createNewNoteButtonListener() {
        binding.createNewNoteButton.setOnClickListener {
            findNavController().navigate(MyNotesFragmentDirections.actionMyNotesFragmentToNewNoteFragment())
        }
    }

    private fun checkEmptyList(noteList: List<Note>){
        if (noteList.isEmpty()){
            binding.tvEmptyUi.setVisible()
            binding.noteRecyclerView.setGone()
        } else {
            binding.tvEmptyUi.setGone()
            binding.noteRecyclerView.setVisible()
        }
    }

    private fun noteObserver() {
        viewModel.noteList.observe(viewLifecycleOwner) {
            myNotesAdapter = MyNotesAdapter(
                it,
                itemClick = { noteItem->
                    findNavController().navigate(MyNotesFragmentDirections.actionMyNotesFragmentToUpdateNoteFragment(noteItem))
                },
                deleteButtonClick = { deleteNote ->
                    viewModel.deleteNote(deleteNote)
                })
            binding.noteRecyclerView.adapter = myNotesAdapter
            checkEmptyList(it)
        }
    }
}