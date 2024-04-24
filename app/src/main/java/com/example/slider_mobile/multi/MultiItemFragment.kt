package com.example.slider_mobile.multi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.slider_mobile.MainActivity
import com.example.slider_mobile.R
import com.example.slider_mobile.databinding.FragmentMultiItemBinding

class MultiItemFragment : Fragment() {

    private var _binding : FragmentMultiItemBinding? = null
    private val binding: FragmentMultiItemBinding
        get() = _binding!!

    var strParam = ""

    companion object {
        fun newInstance() : MultiItemFragment {
            val fragment = MultiItemFragment()
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
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_multi_item,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setJsonParam()
        binding.apply {

            //tvMessage.text = strParam

            incTitlebar.txtTitle.text = "Multi"
            incTitlebar.btnBack.setOnClickListener {
                val act = activity as MainActivity
                act.navigateUp("MULTI")
            }

        }
    }
}