package com.example.basic_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.basic_mobile.databinding.ActivityMainBinding
import com.example.basic_mobile.common.hide
import com.example.basic_mobile.common.setSafeOnClickListener
import com.example.basic_mobile.common.show
import com.example.basic_mobile.ui.CustomDrawerMenu
import com.example.basic_mobile.ui.TitleBar
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

    }

}