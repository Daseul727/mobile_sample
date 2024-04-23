package com.example.slider_mobile.text

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.slider_mobile.MainActivity
import com.example.slider_mobile.R
import com.example.slider_mobile.databinding.FragmentImageBinding
import com.example.slider_mobile.image.ImageFragment

class TextFragment : Fragment() {

    private var _binding: FragmentImageBinding? = null
    private val binding: FragmentImageBinding
        get() = _binding!!

    var strParam = ""

    companion object {
        fun newInstance(): ImageFragment {
            val fragment = ImageFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_image, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    
        initTitleBar()
        
    }
    
    private fun initTitleBar() {
        binding.incTitlebar.txtTitle.text = "TEXT"
        binding.incTitlebar.btnBack.setOnClickListener {
            val act = activity as MainActivity
            act.navigateUp("TEXT")
        }
    }
}