package com.example.basic_mobile.ui

import android.content.Context
import android.provider.ContactsContract.Data
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.basic_mobile.databinding.IncTitlebarBinding
import com.example.basic_mobile.ext.hide
import com.example.basic_mobile.ext.setSafeOnClickListener
import com.example.basic_mobile.ext.show

class TitleBar : FrameLayout {
    companion object {
        const val BUTTON_NAME_BACK = 1
        const val BUTTON_NAME_HOME_RIGHT_SIDE = 2
        const val BUTTON_NAME_HOME = 3
        const val BUTTON_NAME_CLOSE = 4
    }

    constructor(context: Context) : super(context) {
        inflateView()
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        inflateView()
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        inflateView()
        initView()
    }

    private var binding: IncTitlebarBinding? = null
    private  var dataChangeListener: DataChangeListener? = null

    private fun inflateView() {
        binding = IncTitlebarBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)
    }

    private fun initView() {

        //클릭이벤트
        binding?.ivMenu?.setOnClickListener() {
            if(dataChangeListener != null)
                this.dataChangeListener?.onChanged(BUTTON_NAME_HOME_RIGHT_SIDE,"")
        }
    }

    /**
     * set title (TEXT)
     */
    fun setTitle(title:String) {
        if (title.isNullOrEmpty()) {
            binding?.tvTitle?.hide()
        } else {
            binding?.tvTitle?.show()
            binding?.tvTitle?.text = title
        }
    }

    fun showMenuIcon(b: Boolean) {
        if (b) {
            binding?.ivMenu?.show()
        } else {
            binding?.ivMenu?.hide()
        }
    }

    fun setOnClickBackBtnListener(listener: (Int, String) -> Unit) {
        this.dataChangeListener = object : DataChangeListener {
            override fun onChanged(index: Int, value: String) {
                listener(index, value)
            }
        }
    }

    interface DataChangeListener {
        fun onChanged(index: Int,  value : String);
    }

}