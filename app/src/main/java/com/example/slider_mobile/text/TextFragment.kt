package com.example.slider_mobile.text

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.slider_mobile.MainActivity
import com.example.slider_mobile.R
import com.example.slider_mobile.databinding.FragmentTextBinding
import com.example.slider_mobile.multi.MultiItemFragment

class TextFragment : Fragment() {

    private var _binding: FragmentTextBinding? = null
    private val binding: FragmentTextBinding
        get() = _binding!!

    var strParam = ""

    companion object {

        val TAG = TextFragment::class.java.simpleName
        var bannerPosition = 0

        fun newInstance(): MultiItemFragment {
            val fragment = MultiItemFragment()
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
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_text, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    
        initTitleBar()

        val list: ArrayList<Data> = ArrayList()
        list.apply {
            add(Data("Q1. #블라블라","블라블라"))
            add(Data("Q2. #블라블라","블라블라"))
            add(Data("Q3. #블라블라","블라블라"))
            add(Data("Q4. #블라블라","블라블라"))
            add(Data("Q5. #마이페이지","블라블라"))
            add(Data("Q6. #블라블라","블라블라"))
            add(Data("Q7. #블라블라","블라블라"))
            add(Data("Q8. #블라블라","블라블라"))
            add(Data("Q9. #블라블라","블라블라"))
            add(Data("Q10. #블라블라","블라블라"))
            add(Data("Q11. #블라블라","블라블라"))
            add(Data("Q12. #블라블라","블라블라"))
            add(Data("Q13. #블라블라","블라블라"))
        }


        //무한스크롤
        bannerPosition = (Int.MAX_VALUE / 2) - ((Int.MAX_VALUE / 2) % list.size)
        binding.vpText.setCurrentItem(bannerPosition, false)
        binding.vpText.adapter = TextViewPagerAdapter(list)

        binding.vpTextBox.adapter = TextBoxViewPagerAdapter(list)
    }
    
    private fun initTitleBar() {
        binding.incTitlebar.txtTitle.text = "TEXT"
        binding.incTitlebar.btnBack.setOnClickListener {
            val act = activity as MainActivity
            act.navigateUp("TEXT")
        }
    }
}