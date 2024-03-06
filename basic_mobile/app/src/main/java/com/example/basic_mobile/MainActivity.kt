package com.example.basic_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import com.example.basic_mobile.databinding.ActivityMainBinding
import com.example.basic_mobile.ext.hide
import com.example.basic_mobile.ext.show
import com.example.basic_mobile.ui.CustomDrawerMenu
import com.example.basic_mobile.ui.TitleBar

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
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

}