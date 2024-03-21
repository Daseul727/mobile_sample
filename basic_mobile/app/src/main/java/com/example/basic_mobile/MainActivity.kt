package com.example.basic_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.basic_mobile.databinding.ActivityMainBinding
import com.example.basic_mobile.common.hide
import com.example.basic_mobile.common.show
import com.example.basic_mobile.ui.CustomDrawerMenu
import com.example.basic_mobile.ui.TitleBar
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initNavigation()
        setTitleBar()

    }

    private fun setTitleBar () {
        binding?.incTitlebar?.setTitle("MAIN")
        binding?.incTitlebar?.showMenuIcon(true)
        binding?.incTitlebar?.setOnClickBackBtnListener { i, s ->
            when (i) {
                TitleBar.BUTTON_NAME_HOME -> {}
                TitleBar.BUTTON_NAME_BACK -> {}
                TitleBar.BUTTON_NAME_HOME_MENU -> {
                    if (binding?.navView?.isVisible == true) {
                        binding?.navView?.hide()
                    } else {
                        binding?.navView?.show()
                    }

                }
            }
        }
    }

    private fun initNavigation() {
        binding?.incDrawerMenuItems?.setOnClickMenuListener {
            when(it) {
                CustomDrawerMenu.MenuItem.home -> {
                    binding?.navView?.hide()
                }
                CustomDrawerMenu.MenuItem.recyclerView -> {
                    binding?.navView?.hide()
                }
                else -> {
                    binding?.navView?.hide()
                }
            }
        }

    }

}