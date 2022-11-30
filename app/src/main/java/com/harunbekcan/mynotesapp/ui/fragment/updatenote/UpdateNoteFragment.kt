package com.harunbekcan.mynotesapp.ui.fragment.updatenote

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.databinding.FragmentUpdateNoteBinding
import com.harunbekcan.mynotesapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateNoteFragment : BaseFragment<FragmentUpdateNoteBinding>() {

    private val navArgs : UpdateNoteFragmentArgs by navArgs()
    private val viewModel : UpdateNoteViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_update_note

    override fun prepareView(savedInstanceState: Bundle?) {
        setToolbar()
        setData()
        updateNoteObserver()
    }

    private fun setToolbar(){
        binding.updateNoteToolbar.apply {
            toolbarTitle.text = getString(R.string.update_note)
        }
    }

    private fun setData(){
        navArgs.noteItem.let {
            binding.noteTitleEditText.setText(it.title)
            binding.noteDescriptionEditText.setText(it.description)
            updateNoteButtonListener(it.id)
        }
    }

    private fun updateNoteButtonListener(noteId: Int){
        binding.updateNoteButton.setOnClickListener {
            viewModel.updateMyNote(binding.noteTitleEditText.text.toString(),binding.noteDescriptionEditText.text.toString(),noteId)
        }
    }

    private fun updateNoteObserver(){
        viewModel.updateNoteMessage.observe(viewLifecycleOwner){
            when (it.status) {
                Status.SUCCESS -> {
                    Toast.makeText(requireActivity(),"Your note has been successfully updated.", Toast.LENGTH_LONG).show()
                    findNavController().navigate(UpdateNoteFragmentDirections.actionUpdateNoteFragmentToMyNotesFragment())
                }

                Status.ERROR -> {
                    Toast.makeText(requireContext(),it.message ?: "Failed to update your note.", Toast.LENGTH_LONG).show()
                }

                Status.LOADING -> {}
            }
        }
    }
}