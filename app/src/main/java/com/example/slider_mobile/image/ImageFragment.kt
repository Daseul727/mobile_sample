package com.example.slider_mobile.image

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

class ImageFragment : Fragment() {

    private var _binding : FragmentImageBinding? = null
    private val binding: FragmentImageBinding
        get() = _binding!!

    var strParam = ""

    companion object {
        fun newInstance() : ImageFragment {
            val fragment = ImageFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    fun setJsonParam() {
        val bundle = arguments
        bundle?.let {
            strParam = it.getString("param", "").toString()
            Log.d("TLOG - SecondFragment", "받은값 : $strParam")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_image,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setJsonParam()
        binding.apply {

            //tvMessage.text = strParam

            incTitlebar.txtTitle.text = "Second"
            incTitlebar.btnBack.setOnClickListener {
                val act = activity as MainActivity
                act.navigateUp("DOG")

            }

        }
    }
}