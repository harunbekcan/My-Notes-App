package com.harunbekcan.mynotesapp.ui.activity

import android.os.Bundle
import com.harunbekcan.mynotesapp.R
import com.harunbekcan.mynotesapp.base.BaseActivity
import com.harunbekcan.mynotesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun prepareView(savedInstanceState: Bundle?) {}

}