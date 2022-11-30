package com.harunbekcan.mynotesapp.ui.fragment.notedetail

import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.databinding.FragmentNoteDetailBinding
import com.harunbekcan.mynotesapp.utils.setVisible

class NoteDetailFragment : BaseFragment<FragmentNoteDetailBinding>() {

    private val navArgs : NoteDetailFragmentArgs by navArgs()

    override fun getLayoutId(): Int = R.layout.fragment_note_detail

    override fun prepareView(savedInstanceState: Bundle?) {
        initToolbar()
        initUi()
    }

    private fun initToolbar(){
        binding.noteDetailToolbar.apply {
            backButtonImageView.setVisible()
            toolbarBackButtonListener(backButtonImageView)
        }
    }

    private fun initUi(){
        navArgs.noteItem.let {
            binding.noteTitleEditText.setText(it.title)
            binding.noteDescriptionEditText.setText(it.description)
        }
    }

    private fun toolbarBackButtonListener(backButton:ImageView) {
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}