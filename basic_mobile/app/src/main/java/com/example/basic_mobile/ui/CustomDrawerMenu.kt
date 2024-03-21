package com.example.basic_mobile.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.basic_mobile.databinding.DrawerMenuItemsBinding
import com.example.basic_mobile.common.setSafeOnClickListener

class CustomDrawerMenu : FrameLayout {

    private var binding: DrawerMenuItemsBinding? = null

    enum class MenuItem {
        home,
        recyclerView
    }

    constructor(context: Context) : super(context) {
        inflateView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        inflateView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        inflateView()
    }

    private fun inflateView() {
        binding = DrawerMenuItemsBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)
    }

    fun setOnClickMenuListener ( onClick: (MenuItem) -> Unit) {
        binding?.llItem1?.setSafeOnClickListener {
            onClick(MenuItem.home)
        }
        binding?.llItem2?.setSafeOnClickListener {
            onClick(MenuItem.recyclerView)
        }
    }

}