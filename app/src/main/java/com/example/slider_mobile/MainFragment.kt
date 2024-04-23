package com.example.slider_mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.slider_mobile.banner.BannerFragment
import com.example.slider_mobile.databinding.FragmentMainBinding
import com.example.slider_mobile.image.ImageFragment
import com.example.slider_mobile.text.TextFragment

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_main, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            incTitlebar.btnBack.visibility = View.GONE
            incTitlebar.txtTitle.text = "MAIN"

            btnVpText.setOnClickListener {
                val act = activity as MainActivity
                act.openFragment(TextFragment() , "TEXT")
            }

            btnVpImage.setOnClickListener {
                val act = activity as MainActivity
                act.openFragment(ImageFragment() , "IMAGE")
            }

            btnVpBanner.setOnClickListener {
                val act = activity as MainActivity
                act.openFragment(BannerFragment() , "BANNER")
            }
        }
    }

}