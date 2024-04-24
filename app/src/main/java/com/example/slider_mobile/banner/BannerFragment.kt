package com.example.slider_mobile.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.slider_mobile.MainActivity
import com.example.slider_mobile.R
import com.example.slider_mobile.databinding.FragmentBannerBinding

class BannerFragment : Fragment() {
    private var _binding : FragmentBannerBinding? = null
    private val binding : FragmentBannerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_banner, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            incTitlebar2.btnBack.setOnClickListener {
                val act = activity as MainActivity
                act.navigateUp("BANNER")
            }

            incTitlebar2.txtTitle.text = "Banner"

            viewPagerNormal.adapter = context?.let { BannerViewPagerAdapter(it) }

        }
    }
}