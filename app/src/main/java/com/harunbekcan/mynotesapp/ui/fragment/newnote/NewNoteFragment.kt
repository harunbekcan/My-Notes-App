package com.harunbekcan.mynotesapp.ui.fragment.newnote

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.databinding.FragmentNewNoteBinding
import com.harunbekcan.mynotesapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewNoteFragment : BaseFragment<FragmentNewNoteBinding>() {

    private val viewModel : NewNoteViewModel by viewModels()
    override fun getLayoutId(): Int = R.layout.fragment_new_note

    override fun prepareView(savedInstanceState: Bundle?) {
        initToolbar()
        createNoteButtonListener()
        initObserver()
    }

    private fun initToolbar(){
        binding.newNoteToolbar.apply {
            toolbarTitle.text = getString(R.string.create_note)
        }
    }

    private fun createNoteButtonListener(){
        binding.createNoteButton.setOnClickListener {
            viewModel.addNote(binding.noteTitleEditText.text.toString(), binding.noteDescriptionEditText.text.toString(),-1)
        }
    }

    private fun initObserver(){
        viewModel.noteMessage.observe(viewLifecycleOwner){
            when (it.status) {
                Status.SUCCESS -> {
                    Toast.makeText(requireActivity(),"Success", Toast.LENGTH_LONG).show()
                    findNavController().navigateUp()
                }

                Status.ERROR -> {
                    Toast.makeText(requireContext(),it.message ?: "Error", Toast.LENGTH_LONG).show()
                }

                Status.LOADING -> {}
            }
        }
    }
}