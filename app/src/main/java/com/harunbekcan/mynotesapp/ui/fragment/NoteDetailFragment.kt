package com.harunbekcan.mynotesapp.ui.fragment

import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.databinding.FragmentNoteDetailBinding
import com.harunbekcan.mynotesapp.utils.setVisible

class NoteDetailFragment : BaseFragment<FragmentNoteDetailBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_note_detail

    override fun prepareView(savedInstanceState: Bundle?) {
        initToolbar()
    }

    private fun initToolbar(){
        binding.myNoteDetailToolbar.apply {
            backButtonImageView.setVisible()
            toolbarBackButtonListener(backButtonImageView)
        }
    }

    private fun toolbarBackButtonListener(backButton:ImageView) {
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}