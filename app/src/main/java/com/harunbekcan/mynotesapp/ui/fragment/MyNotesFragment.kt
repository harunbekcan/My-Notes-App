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
        addNewNoteButtonListener()
    }

    private fun addNewNoteButtonListener(){
        binding.addNewNoteButton.setOnClickListener {
            findNavController().navigate(MyNotesFragmentDirections.actionMyNotesFragmentToNoteDetailFragment())
        }
    }
}