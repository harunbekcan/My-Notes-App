package com.harunbekcan.mynotesapp

import android.os.Bundle
import com.harunbekcan.mynotesapp.base.BaseActivity
import com.harunbekcan.mynotesapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun prepareView(savedInstanceState: Bundle?) {}

}