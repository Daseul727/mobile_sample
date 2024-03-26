package com.example.basic_mobile.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.basic_mobile.common.hide
import com.example.basic_mobile.common.show
import com.example.basic_mobile.databinding.FragmentHomeBinding
import com.example.basic_mobile.ui.CustomDrawerMenu
import com.example.basic_mobile.ui.TitleBar

class HomeFragment : Fragment(){
    private var _binding: FragmentHomeBinding? = null
    private val mViewDataBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return mViewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNavigation()
        setTitleBar()
        //init 작업 수행
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setTitleBar () {
        _binding?.incTitle?.setTitle("MAIN")
        _binding?.incTitle?.showMenuIcon(true)
        _binding?.incTitle?.setOnClickBackBtnListener { i, s ->
            when (i) {
                TitleBar.BUTTON_NAME_HOME -> {}
                TitleBar.BUTTON_NAME_BACK -> {}
                TitleBar.BUTTON_NAME_HOME_MENU -> {
                    if (_binding?.navView?.isVisible == true) {
                        _binding?.navView?.hide()
                    } else {
                        _binding?.navView?.show()
                    }

                }
            }
        }
    }

    private fun initNavigation() {
        _binding?.incDrawerMenuItems?.setOnClickMenuListener {
            when(it) {
                CustomDrawerMenu.MenuItem.home -> {
                    _binding?.navView?.hide()
                }
                CustomDrawerMenu.MenuItem.recyclerView -> {
                    _binding?.navView?.hide()
                }
                else -> {
                    _binding?.navView?.hide()
                }
            }
        }

    }
}