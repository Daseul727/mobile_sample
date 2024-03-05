package com.example.basic_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basic_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setTitleBar()
    }

    private fun setTitleBar () {
        binding?.incTitlebar?.setTitle("MAIN")
        binding?.incTitlebar?.showMenuIcon(true)
    }
}