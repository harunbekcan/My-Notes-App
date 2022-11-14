package com.harunbekcan.mynotesapp.ui.fragment

import android.os.Bundle
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : BaseFragment<FragmentNoteDetailBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_note_detail

    override fun prepareView(savedInstanceState: Bundle?) {}

}