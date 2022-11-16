package com.harunbekcan.mynotesapp.ui.fragment

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.databinding.FragmentMyNotesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyNotesFragment : BaseFragment<FragmentMyNotesBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_my_notes

    override fun prepareView(savedInstanceState: Bundle?) {
        initToolbar()
        createNewNoteButtonListener()
    }

    private fun initToolbar(){
        binding.myNotesToolbar.apply {
            toolbarTitle.text = getString(R.string.my_notes)
        }
    }

    private fun createNewNoteButtonListener(){
        binding.createNewNoteButton.setOnClickListener {
            findNavController().navigate(MyNotesFragmentDirections.actionMyNotesFragmentToNewNoteFragment())
        }
    }
}