package com.harunbekcan.mynotesapp.ui.fragment

import android.os.Bundle
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseFragment
import com.harunbekcan.mynotesapp.databinding.FragmentNewNoteBinding

class NewNoteFragment : BaseFragment<FragmentNewNoteBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_new_note

    override fun prepareView(savedInstanceState: Bundle?) {}
}